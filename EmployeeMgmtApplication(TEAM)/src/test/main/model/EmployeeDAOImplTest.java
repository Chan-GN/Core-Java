package main.model;

import main.util.DbUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EmployeeDAOImplTest {

    // EmployeeDAOImpl 인스턴스를 테스트하기 위해 선언
    private EmployeeDAOImpl employeeDAO;

    // DbUtil을 모킹하기 위해 선언
    @Mock
    private DbUtil dbUtil;

    // 모킹된 데이터베이스 연결을 위해 선언
    @Mock
    private Connection mockConnection;

    // 모킹된 PreparedStatement를 위해 선언
    @Mock
    private PreparedStatement mockPreparedStatement;

    // 모킹된 ResultSet을 위해 선언
    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws SQLException {
        // Mockito 어노테이션을 초기화
        MockitoAnnotations.openMocks(this);

        // EmployeeDAOImpl 인스턴스 생성
        employeeDAO = new EmployeeDAOImpl();

        // DbUtil 필드를 모킹된 객체로 설정
        ReflectionTestUtils.setField(employeeDAO, "dbUtil", dbUtil);

        // 모킹된 연결 설정
        when(dbUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    void testSave() throws SQLException {
        // 테스트할 EmployeeDTO 객체 생성
        EmployeeDTO employee = new EmployeeDTO("E001", "John Doe", 1, 1,
                2, DepartmentCode.A, 3);

        // PreparedStatement가 성공적으로 실행되었다고 가정
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        // save 메서드 실행
        boolean result = employeeDAO.save(employee);

        // 결과가 true인지 확인
        assertTrue(result, "Employee should be saved successfully");

        // PreparedStatement에 올바른 값이 설정되었는지 확인
        verify(mockPreparedStatement).setString(1, "E001");
        verify(mockPreparedStatement).setString(2, "John Doe");
        verify(mockPreparedStatement).setInt(3, 1);
        verify(mockPreparedStatement).setInt(4, 1);
        verify(mockPreparedStatement).setInt(5, 2);
        verify(mockPreparedStatement).setString(6, "A");
        verify(mockPreparedStatement).setInt(7, 3);

        // executeUpdate가 한 번 호출되었는지 확인
        verify(mockPreparedStatement, times(1)).executeUpdate();
    }

    @Test
    void testFindAll() throws SQLException {
        // ResultSet이 두 개의 행을 반환한다고 가정
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true, true, false);

        // ResultSet에서 반환할 값 설정
        when(mockResultSet.getString("id")).thenReturn("E001", "E002");
        when(mockResultSet.getString("name")).thenReturn("John Doe", "Jane Doe");
        when(mockResultSet.getInt("basic_salary_code")).thenReturn(1, 2);
        when(mockResultSet.getInt("night_hours")).thenReturn(1, 2);
        when(mockResultSet.getInt("number_of_family_members")).thenReturn(2, 1);
        when(mockResultSet.getString("department_code")).thenReturn("A", "B");
        when(mockResultSet.getInt("grade_allowance_code")).thenReturn(3, 4);

        // findAll 메서드 실행
        List<EmployeeDTO> employees = employeeDAO.findAll();

        // 결과 확인
        assertNotNull(employees, "Returned list should not be null");
        assertEquals(2, employees.size(), "Should return 2 employees");

        // 첫 번째 직원 확인
        EmployeeDTO employee1 = employees.get(0);
        assertEquals("E001", employee1.getId());
        assertEquals("John Doe", employee1.getName());
        assertEquals(1, employee1.getBasicSalaryCode());
        assertEquals(1, employee1.getNightHours());
        assertEquals(2, employee1.getNumberOfFamilyMembers());
        assertEquals(DepartmentCode.A, employee1.getDepartmentCode());
        assertEquals(3, employee1.getGradeAllowanceCode());

        // 두 번째 직원 확인
        EmployeeDTO employee2 = employees.get(1);
        assertEquals("E002", employee2.getId());
        assertEquals("Jane Doe", employee2.getName());
        assertEquals(2, employee2.getBasicSalaryCode());
        assertEquals(2, employee2.getNightHours());
        assertEquals(1, employee2.getNumberOfFamilyMembers());
        assertEquals(DepartmentCode.B, employee2.getDepartmentCode());
        assertEquals(4, employee2.getGradeAllowanceCode());

        // executeQuery가 한 번 호출되었는지 확인
        verify(mockPreparedStatement, times(1)).executeQuery();
    }

    @Test
    void testFindByIdExistingEmployee() throws SQLException {
        // 존재하는 직원 테스트 로직
        // 테스트 데이터 설정
        String testId = "E001";
        EmployeeDTO expectedEmployee = new EmployeeDTO(testId, "John Doe", 1, 2, 2, DepartmentCode.A, 3);

        // ResultSet 모킹
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getString("id")).thenReturn(testId);
        when(mockResultSet.getString("name")).thenReturn("John Doe");
        when(mockResultSet.getInt("basic_salary_code")).thenReturn(1);
        when(mockResultSet.getInt("night_hours")).thenReturn(2);
        when(mockResultSet.getInt("number_of_family_members")).thenReturn(2);
        when(mockResultSet.getString("department_code")).thenReturn("A");
        when(mockResultSet.getInt("grade_allowance_code")).thenReturn(3);

        // findById 메서드 호출
        Optional<EmployeeDTO> actualEmployee = employeeDAO.findById(testId);

        // 결과 검증
        assertTrue(actualEmployee.isPresent());
        assertEquals(expectedEmployee.getId(), actualEmployee.get().getId());
        assertEquals(expectedEmployee.getName(), actualEmployee.get().getName());
        assertEquals(expectedEmployee.getBasicSalaryCode(), actualEmployee.get().getBasicSalaryCode());
        assertEquals(expectedEmployee.getNightHours(), actualEmployee.get().getNightHours());
        assertEquals(expectedEmployee.getNumberOfFamilyMembers(), actualEmployee.get().getNumberOfFamilyMembers());
        assertEquals(expectedEmployee.getDepartmentCode(), actualEmployee.get().getDepartmentCode());
        assertEquals(expectedEmployee.getGradeAllowanceCode(), actualEmployee.get().getGradeAllowanceCode());

        // PreparedStatement 설정 검증
        verify(mockPreparedStatement).setString(1, testId);
        verify(mockPreparedStatement).executeQuery();
    }

    @Test
    void testFindByIdNonExistentEmployee() throws SQLException {
        // 존재하지 않는 직원 테스트 로직
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);
        Optional<EmployeeDTO> nonExistentEmployee = employeeDAO.findById("E999");
        assertTrue(nonExistentEmployee.isEmpty());
    }

    @AfterEach
    void tearDown() {
        verify(dbUtil).close(eq(mockConnection), eq(mockPreparedStatement), any());
    }

}