package com.example.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static final Properties info = new Properties();
    private static final String CONFIG_FILE = "resources/dbinfo.properties";

    static {
        File file = new File(CONFIG_FILE);
        try {
            info.load(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private DBConnection() {

    }

    public static Connection getConnection() throws SQLException {
        try {
            // Class.forName(info.getProperty("DB_DRIVER"));
            return DriverManager.getConnection(
                    info.getProperty("DB_URL"),
                    info.getProperty("DB_USER"),
                    info.getProperty("DB_PASSWD")
            );
        } catch (SQLException e) {
            throw new SQLException("데이터베이스 연결 정보가 불완전합니다.");
        }
    }

}
