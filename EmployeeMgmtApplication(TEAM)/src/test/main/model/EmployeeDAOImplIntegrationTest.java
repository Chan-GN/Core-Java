package main.model;

import main.util.DbUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOImplIntegrationTest {

    private static final String TEST_DB_PROPERTIES_PATH = "/db/dbinfo.properties";
    private static Connection connection;
    private static EmployeeDAOImpl employeeDAO;

    @BeforeAll
    static void setUpDatabase() throws SQLException {
        // 데이터베이스 연결 설정
        Properties props = new Properties();

        // EmployeeDAOImpl 인스턴스 생성
        DbUtil dbUtil = new DbUtil(props);
        connection = dbUtil.getConnection(TEST_DB_PROPERTIES_PATH);
        employeeDAO = new EmployeeDAOImpl(dbUtil);

        // 테스트 테이블 생성
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS employee (" +
                    "id VARCHAR(10) PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "basic_salary_code INT, " +
                    "night_hours INT, " +
                    "number_of_family_members INT, " +
                    "department_code VARCHAR(10), " +
                    "grade_allowance_code INT)");
        }
    }

    @AfterAll
    static void tearDownDatabase() throws SQLException {
        // 테스트 테이블 삭제
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS employee");
        }
        // 데이터베이스 연결 종료
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @BeforeEach
    void setUpTestData() throws SQLException {
        // 테스트 데이터 삽입
        try (PreparedStatement pstmt = connection.prepareStatement(
                "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, "E001");
            pstmt.setString(2, "John Doe");
            pstmt.setInt(3, 1);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, 2);
            pstmt.setString(6, "A");
            pstmt.setInt(7, 3);
            pstmt.executeUpdate();
        }
    }

    @Test
    void testSave() {
        EmployeeDTO employee = new EmployeeDTO("E002", "Jane Doe", 2, 2, 1, DepartmentCode.A, 4);
        boolean result = employeeDAO.save(employee);
        assertTrue(result);

        // DB에서 직접 데이터 확인
        Optional<EmployeeDTO> savedEmployee = employeeDAO.findById("E002");
        assertTrue(savedEmployee.isPresent());
        assertEquals(employee.getName(), savedEmployee.get().getName());
        assertEquals(employee.getBasicSalaryCode(), savedEmployee.get().getBasicSalaryCode());
        assertEquals(employee.getNightHours(), savedEmployee.get().getNightHours());
        assertEquals(employee.getNumberOfFamilyMembers(), savedEmployee.get().getNumberOfFamilyMembers());
        assertEquals(employee.getDepartmentCode(), savedEmployee.get().getDepartmentCode());
        assertEquals(employee.getGradeAllowanceCode(), savedEmployee.get().getGradeAllowanceCode());
    }

    @Test
    void testFindAll() {
        List<EmployeeDTO> employees = employeeDAO.findAll();
        assertFalse(employees.isEmpty());
        assertTrue(employees.stream().anyMatch(e -> e.getId().equals("E001")));
    }

    @Test
    void testFindById() {
        // 테스트 데이터 준비
        EmployeeDTO expectedEmployee = new EmployeeDTO("E001", "John Doe", 1, 0, 2, DepartmentCode.A, 3);

        // findById 메서드 호출
        Optional<EmployeeDTO> actualEmployee = employeeDAO.findById("E001");

        assertTrue(actualEmployee.isPresent());

        // 결과 검증
        assertNotNull(actualEmployee.get(), "Employee should not be null");
        assertEquals(expectedEmployee.getId(), actualEmployee.get().getId());
        assertEquals(expectedEmployee.getName(), actualEmployee.get().getName());
        assertEquals(expectedEmployee.getBasicSalaryCode(), actualEmployee.get().getBasicSalaryCode());
        assertEquals(expectedEmployee.getNightHours(), actualEmployee.get().getNightHours());
        assertEquals(expectedEmployee.getNumberOfFamilyMembers(), actualEmployee.get().getNumberOfFamilyMembers());
        assertEquals(expectedEmployee.getDepartmentCode(), actualEmployee.get().getDepartmentCode());
        assertEquals(expectedEmployee.getGradeAllowanceCode(), actualEmployee.get().getGradeAllowanceCode());

        // 존재하지 않는 ID로 테스트
        Optional<EmployeeDTO> nonExistentEmployee = employeeDAO.findById("E999");
        assertTrue(nonExistentEmployee.isEmpty());
    }

    @AfterEach
    void cleanUpTestData() throws SQLException {
        // 테스트 데이터 삭제
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DELETE FROM employee");
        }
    }

}