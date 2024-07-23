package main.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3 {

    public static void main(String[] args) {
        String sql = "SELECT emp.deptno, dname, ROUND(AVG(sal), 1) AS 평균, ROUND(SUM(sal), 1) AS 총합 " +
                "FROM emp JOIN dept ON(emp.deptno = dept.deptno) " +
                "GROUP BY deptno " +
                "ORDER BY 평균 DESC";

        Connection conn = new DBConnection().getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.printf("%d\t%s\t%.1f\t%.1f\n", rs.getInt("emp.deptno"),
                        rs.getString("dname"), rs.getDouble("평균"),
                        rs.getDouble("총합"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose.dbClose(conn, stmt, rs);
        }
    }

}
