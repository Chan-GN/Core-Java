package main.model;

import main.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 작성자: 이요한
 * 작성일: 2024-08-01
 * 작성 목적
 * - EmployeeDAO 구현
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String INSERT_SQL = """
            INSERT INTO employee
            VALUES (?, ?, ?, ?, ?, ?, ?)""";
    private static final String FIND_ALL_SQL = "SELECT * FROM employee";

    private final DbUtil dbUtil;

    public EmployeeDAOImpl() {
        this.dbUtil = new DbUtil();
    }

    private static List<EmployeeDTO> getAllEmployees(ResultSet rs) throws SQLException {
        List<EmployeeDTO> employees = new ArrayList<>();

        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            int basicSalary = rs.getInt("basic_salary_code");
            int nightHours = rs.getInt("night_hours");
            int numberOfFamilyMembers = rs.getInt("number_of_family_members");
            String departmentCode = rs.getString("department_code");
            int gradeAllowanceCode = rs.getInt("grade_allowance_code");

            EmployeeDTO employee = new EmployeeDTO(
                    id, name,
                    basicSalary,
                    nightHours,
                    numberOfFamilyMembers,
                    DepartmentCode.valueOf(departmentCode),
                    gradeAllowanceCode
            );

            employees.add(employee);
        }

        return employees;
    }

    @Override
    public boolean save(EmployeeDTO employee) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbUtil.getConnection();
            pstmt = conn.prepareStatement(INSERT_SQL);

            return updateEmployee(employee, pstmt);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            dbUtil.close(conn, pstmt, null);
        }
    }

    @Override
    public List<EmployeeDTO> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dbUtil.getConnection();

            pstmt = conn.prepareStatement(FIND_ALL_SQL);

            rs = pstmt.executeQuery();

            return getAllEmployees(rs);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            dbUtil.close(conn, pstmt, rs);
        }
    }

    private boolean updateEmployee(EmployeeDTO employee, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, employee.getId());
        pstmt.setString(2, employee.getName());
        pstmt.setInt(3, employee.getBasicSalaryCode());
        pstmt.setInt(4, employee.getNightHours());
        pstmt.setInt(5, employee.getNumberOfFamilyMembers());
        pstmt.setString(6, employee.getDepartmentCode().name());
        pstmt.setInt(7, employee.getGradeAllowanceCode());

        return pstmt.executeUpdate() == 1;
    }

}