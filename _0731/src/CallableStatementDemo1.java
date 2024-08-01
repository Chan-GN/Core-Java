import java.sql.*;

public class CallableStatementDemo1 {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBConnection.getConnection();

        String sql = "{call sp_test(?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);

        cstmt.registerOutParameter(1, Types.DATE);
        cstmt.registerOutParameter(2, Types.VARCHAR);
        cstmt.execute();

        Date date = cstmt.getDate(1);
        String str = cstmt.getString(2);

        System.out.println(date + ", " + str);

        DBClose.dbClose(conn, cstmt);
    }

}

/*
    DELIMITER //
    CREATE PROCEDURE sp_test(
        OUT v_now DATETIME,
        OUT v_version VARCHAR(30)
    )
    BEGIN
        SELECT NOW(), VERSION() INTO v_now, v_version;
    END //
    DELIMITER ;
*/