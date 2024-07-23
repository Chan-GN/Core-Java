package main.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

    public static void main(String[] args) {
        DBConnection dc = new DBConnection();
        Connection conn = dc.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            StringBuffer sb = new StringBuffer();
            sb.append("SELECT empno, ename, sal, d.deptno, dname, loc ");
            sb.append("FROM emp e JOIN dept d ON(e.deptno = d.deptno) ");
            sb.append("WHERE ename = 'SMITH'");
            rs = stmt.executeQuery(sb.toString());

            while (rs.next()) {
                System.out.printf("%d\t%s\t%.1f\t%d\t%s\t%s%n",
                        rs.getInt("empno"), rs.getString("ename"),
                        rs.getDouble("sal"), rs.getInt("d.deptno"),
                        rs.getString("dname"), rs.getString("loc"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBClose.dbClose(conn, stmt, rs);
        }
    }

}
