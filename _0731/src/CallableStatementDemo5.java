import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatementDemo5 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "{ call sp_updateDept(?, ?) }";
        CallableStatement cstmt = null;

        try {
            cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, 60);
            cstmt.setString(2, "New York");

            cstmt.execute();

            String result = cstmt.getString(2);

            System.out.println("갱신 성공, 변경된 위치 : " + result);
        } catch (SQLException e) {
            System.out.println("갱신 실패");
            System.out.println(e.getMessage());
        }

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    DELIMITER //
    CREATE PROCEDURE sp_updateDept(
        IN p_deptno INT,
        INOUT p_location VARCHAR(13)
    )
    BEGIN
        UPDATE dept_clone
        SET loc = p_location
        WHERE deptno = p_deptno;
    END //
    DELIMITER ;
*/