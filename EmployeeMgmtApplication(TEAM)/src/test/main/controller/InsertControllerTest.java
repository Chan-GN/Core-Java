package main.controller;

import main.model.DepartmentCode;
import main.model.EmployeeDAO;
import main.model.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class InsertControllerTest {

    @Mock
    private EmployeeDAO employeeDAO;

    private InsertController insertController;

    @BeforeEach
    void setUp() {
        // Mockito 어노테이션 초기화
        MockitoAnnotations.openMocks(this);

        insertController = new InsertController(employeeDAO);
    }

    @Test
    void testSaveEmployee_Success() {
        // 테스트 데이터 준비
        String id = "A1001";
        String name = "Yerin Baek";
        int basicSalaryGrade = 3;
        int nightHours = 4;
        int numberOfFamilyMembers = 2;

        // EmployeeDAO의 save 메소드가 true를 반환하도록 설정
        when(employeeDAO.save(any(EmployeeDTO.class))).thenReturn(true);

        // 메소드 실행
        boolean result = insertController.saveEmployee(id, name, basicSalaryGrade, nightHours, numberOfFamilyMembers);

        // 결과 검증
        assertTrue(result, "Employee should be saved successfully");

        // EmployeeDAO의 save 메소드가 올바른 인자로 호출되었는지 검증
        verify(employeeDAO).save(argThat(employee ->
                employee.getId().equals(id) &&
                        employee.getName().equals(name) &&
                        employee.getBasicSalaryCode() == basicSalaryGrade &&
                        employee.getNightHours() == nightHours &&
                        employee.getNumberOfFamilyMembers() == numberOfFamilyMembers &&
                        employee.getDepartmentCode() == DepartmentCode.A &&
                        employee.getGradeAllowanceCode() == 1
        ));
    }

    @Test
    void testSaveEmployee_Failure() {
        // 테스트 데이터 준비
        String id = "B2002";
        String name = "Jane Doe";
        int basicSalaryGrade = 4;
        int nightHours = 1;
        int numberOfFamilyMembers = 3;

        // EmployeeDAO의 save 메소드가 false를 반환하도록 설정
        when(employeeDAO.save(any(EmployeeDTO.class))).thenReturn(false);

        // 메소드 실행
        boolean result = insertController.saveEmployee(id, name, basicSalaryGrade, nightHours, numberOfFamilyMembers);

        // 결과 검증
        assertFalse(result, "Employee should not be saved");

        // EmployeeDAO의 save 메소드가 호출되었는지 검증
        verify(employeeDAO).save(any(EmployeeDTO.class));
    }

    @Test
    void testSaveEmployee_InvalidDepartmentCode() {
        // 잘못된 부서 코드로 테스트
        String id = "X3003";  // 'X'는 유효하지 않은 부서 코드
        String name = "Invalid Dept";
        int basicSalaryGrade = 2;
        int nightHours = 3;
        int numberOfFamilyMembers = 1;

        // 메소드 실행 및 예외 검증
        assertThrows(IllegalArgumentException.class, () ->
                        insertController.saveEmployee(id, name, basicSalaryGrade, nightHours, numberOfFamilyMembers),
                "Should throw IllegalArgumentException for invalid department code"
        );

        // EmployeeDAO의 save 메소드가 호출되지 않았는지 검증
        verify(employeeDAO, never()).save(any(EmployeeDTO.class));
    }

}