import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementDemo6 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "{ call sp_select_emp_dept(?) }";
        CallableStatement cstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            cstmt = conn.prepareCall(sql);
            System.out.print("부서 번호를 입력하세요. : ");
            int deptno = scanner.nextInt();
            cstmt.setInt(1, deptno);

            ResultSet rs = cstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("해당 부서에 속한 직원이 없습니다.");
            } else {
                do {
                    System.out.println("사원번호: " + rs.getInt("empno") +
                            ", 이름: " + rs.getString("ename") +
                            ", 부서명: " + rs.getString("dname") +
                            ", 위치: " + rs.getString("loc"));
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    -- 부서 번호로 소속 사원의 사원 번호, 사원 이름, 부서 이름, 부서 위치, 부서 번호 SELECT
    DELIMITER //
    CREATE PROCEDURE sp_select_emp_dept(
        IN p_deptno TINYINT
    )
    BEGIN
        SELECT empno, ename, dname, loc, dept.deptno
        FROM emp
                 NATURAL JOIN dept
        WHERE deptno = p_deptno;
    END //
    DELIMITER ;
*/