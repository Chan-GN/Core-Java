package main.java.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final Properties info = new Properties();
    private static final String CONFIG_FILE = "dbinfo.properties";

    static {
        try (InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream != null) {
                info.load(inputStream);
            } else {
                throw new RuntimeException("Cannot find " + CONFIG_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot load " + CONFIG_FILE, e);
        }
    }

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(info.getProperty("DB_DRIVER"));
            return DriverManager.getConnection(
                    info.getProperty("DB_URL"),
                    info.getProperty("DB_USER"),
                    info.getProperty("DB_PASSWD")
            );
        } catch (SQLException e) {
            throw new SQLException("데이터베이스 연결 정보가 불완전합니다.", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

}