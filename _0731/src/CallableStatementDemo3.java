import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementDemo3 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "{ call sp_insertDept(?, ?, ?) }";
        CallableStatement cstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            cstmt = conn.prepareCall(sql);
            System.out.print("부서 번호 : ");
            int deptno = Integer.parseInt(scanner.nextLine());
            System.out.print("부서 이름 : ");
            String dname = scanner.nextLine();
            System.out.print("부서 위치 : ");
            String loc = scanner.nextLine();

            cstmt.setInt(1, deptno);
            cstmt.setString(2, dname);
            cstmt.setString(3, loc);

            cstmt.execute();

            System.out.println("삽입 성공");
        } catch (SQLException e) {
            System.out.println("삽입 실패");
        }

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    DELIMITER //
    CREATE PROCEDURE sp_insertDept(
        IN v_deptno TINYINT,
        IN v_dname VARCHAR(14),
        IN v_loc VARCHAR(13)
    )
    BEGIN
        INSERT INTO dept_clone(deptno, dname, loc)
        VALUES (v_deptno, v_dname, v_loc);
        COMMIT;
    END //
    DELIMITER ;
*/
