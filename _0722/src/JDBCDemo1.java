/*
 * JDBC 연결
 * 1. import java.sql.*
 * 2. Load MySQL Driver
 * 3. Connect
 * 4. Statement 인스턴스 생성
 * 5. Execute Query
 * 6. ResultSet 결과를 Parsing
 * 7. 자원 정리(연결 close)
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo1 {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            Properties properties = new Properties();
            properties.load(new FileInputStream("src/resources/database.properties"));
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mycompany",
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );

            System.out.println("Connection Established!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT now(), version()");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            rs.next();
            String now = rs.getString(1);
            String version = rs.getString(2);
            System.out.println(now + ", " + version);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}