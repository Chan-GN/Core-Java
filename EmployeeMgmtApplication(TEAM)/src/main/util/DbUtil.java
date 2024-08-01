package main.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 작성자: 이요한
 * 작성일: 2024-08-01
 * 작성 목적
 * - 데이터베이스 연결 객체 제공
 * - Connection, PreparedStatement, ResultSet를 위한 close 메서드 구현
 */
public class DbUtil {

    private static final String DEFAULT_DB_PROPERTIES_PATH = "/db/dbinfo.properties";

    private final Properties properties;

    public DbUtil() {
        this.properties = new Properties();
    }

    public Connection getConnection() {
        return getConnection(DEFAULT_DB_PROPERTIES_PATH);
    }

    public Connection getConnection(String propertiesPath) {
        try (InputStream inputStream = getClass().getResourceAsStream(propertiesPath)) {
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            return DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException e) {
            throw new IllegalArgumentException("Failed to establish a database connection", e);
        }
    }

    public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}