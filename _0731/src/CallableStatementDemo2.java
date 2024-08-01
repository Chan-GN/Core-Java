import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatementDemo2 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "{ call sp_deleteDept() }";
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall(sql);
            cstmt.execute();
            System.out.println("삭제 성공");
        } catch (SQLException e) {
            System.out.println("삭제 실패");
        }

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    DELIMITER //
    CREATE PROCEDURE sp_deleteDept()
    BEGIN
        DELETE FROM dept_clone;
    END //
    DELIMITER ;
*/