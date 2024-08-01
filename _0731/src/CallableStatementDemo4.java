import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatementDemo4 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "{ call sp_selectDept(?, ?, ?) }";
        CallableStatement cstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            cstmt = conn.prepareCall(sql);
            System.out.print("사원 번호 : ");
            int empno = scanner.nextInt();

            cstmt.setInt(1, empno);
            cstmt.registerOutParameter(2, Types.VARCHAR);
            cstmt.registerOutParameter(3, Types.VARCHAR);

            cstmt.execute();

            String dname = cstmt.getString("v_dname");
            String loc = cstmt.getString("v_loc");

            System.out.println("해당 사원의 부서 정보는 다음과 같습니다. 부서 이름 : " + dname + ", 부서 위치 : " + loc);
        } catch (SQLException e) {
            System.out.println("검색 실패");
            System.out.println(e.getMessage());
        }

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    DELIMITER //
    CREATE PROCEDURE sp_selectDept(
        IN v_empno VARCHAR(10),
        OUT v_dname VARCHAR(14),
        OUT v_loc VARCHAR(13)
    )
    BEGIN
        SELECT dname, loc
        INTO v_dname, v_loc
        FROM emp
                 JOIN dept ON emp.deptno = dept.deptno
        WHERE empno = v_empno;
    END //
    DELIMITER ;
*/