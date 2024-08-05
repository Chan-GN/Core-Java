package main.controller;

import main.model.DepartmentCode;
import main.model.EmployeeDAO;
import main.model.EmployeeDTO;
import main.model.EmployeeOutputDTO;
import main.util.CalculateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SelectControllerTest {

    @Mock
    private EmployeeDAO employeeDAO;

    @InjectMocks
    private SelectController selectController;

    @Test
    void testGetAllEmployees() {
        // 테스트 데이터 준비
        EmployeeDTO employee1 = new EmployeeDTO("A5234", "John", 3, 4, 2, DepartmentCode.C, 5);
        EmployeeDTO employee2 = new EmployeeDTO("A5224", "Yerin", 2, 3, 2, DepartmentCode.A, 5);
        List<EmployeeDTO> employeeDTOs = Arrays.asList(employee1, employee2);

        when(employeeDAO.findAll()).thenReturn(employeeDTOs);

        // CalculateUtils 모킹
        try (MockedStatic<CalculateUtils> mockedCalculateUtils = Mockito.mockStatic(CalculateUtils.class)) {
            // 첫 번째 직원에 대한 모킹
            mockedCalculateUtils.when(() -> CalculateUtils.calculateGradeAllowanceSalary(5)).thenReturn(100000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateNightAllowance(4)).thenReturn(20000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateFamilyAllowance(2)).thenReturn(30000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateBasicSalary(3)).thenReturn(300000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateTotalAmount(100000, 300000, 20000, 30000)).thenReturn(450000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateNetIncome(100000, 450000)).thenReturn(400000);

            // 두 번째 직원에 대한 모킹
            mockedCalculateUtils.when(() -> CalculateUtils.calculateGradeAllowanceSalary(5)).thenReturn(100000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateNightAllowance(3)).thenReturn(20000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateFamilyAllowance(2)).thenReturn(30000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateBasicSalary(2)).thenReturn(300000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateTotalAmount(100000, 300000, 20000, 30000)).thenReturn(450000);
            mockedCalculateUtils.when(() -> CalculateUtils.calculateNetIncome(100000, 450000)).thenReturn(400000);

            // 메소드 실행
            List<EmployeeOutputDTO> result = selectController.getAllEmployees();

            // 결과 검증
            assertNotNull(result);
            assertEquals(2, result.size());

            EmployeeOutputDTO output1 = result.get(0);
            assertEquals("A5234", output1.getId());
            assertEquals("John", output1.getName());
            assertEquals(3, output1.getBasicSalaryCode());
            assertEquals(100000, output1.getGradeAllowanceSalary());
            assertEquals(30000, output1.getFamilyAllowance());
            assertEquals(20000, output1.getNightAllowance());
            assertEquals(450000, output1.getTotalAmount());
            assertEquals(400000, output1.getNetIncome());

            EmployeeOutputDTO output2 = result.get(1);
            assertEquals("A5224", output2.getId());
            assertEquals("Yerin", output2.getName());
            assertEquals(2, output2.getBasicSalaryCode());
            assertEquals(100000, output2.getGradeAllowanceSalary());
            assertEquals(30000, output2.getFamilyAllowance());
            assertEquals(20000, output2.getNightAllowance());
            assertEquals(450000, output2.getTotalAmount());
            assertEquals(400000, output2.getNetIncome());
        }

        verify(employeeDAO, times(1)).findAll();
    }

    @Test
    void testGetEmployeeById() {

    }

}