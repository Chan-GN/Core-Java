package com.example.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private final Properties info;

    public DBConnection() {
        info = new Properties();
        File file = new File("resources/dbinfo.properties");
        try {
            info.load(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(info.getProperty("DB_DRIVER"));
            conn = DriverManager.getConnection(
                    info.getProperty("DB_URL"),
                    info.getProperty("DB_USER"),
                    info.getProperty("DB_PASSWD")
            );
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
