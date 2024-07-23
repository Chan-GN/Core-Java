package main.java;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo2 {

    private DBConnection dbConnection;
    private Connection conn;

    public JDBCDemo2() {
        this.dbConnection = new DBConnection();
        this.conn = dbConnection.getConnection();
    }

    public static void main(String[] args) {
        JDBCDemo2 demo = new JDBCDemo2();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.next().toUpperCase();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = demo.conn.createStatement();
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT ename, sal, grade ");
            sql.append("FROM emp, salgrade ");
            sql.append("WHERE (sal BETWEEN losal AND hisal) AND ename = ");
            sql.append('\'').append(name).append('\'');
            rs = stmt.executeQuery(sql.toString());
            while (rs.next()) {
                System.out.printf("%s\t%.1f\t%d%n", rs.getString("ename"), rs.getDouble("sal"), rs.getInt("grade"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose.dbClose(demo.conn, stmt, rs);
        }
    }

}
