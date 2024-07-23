import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo2 {

    private static final String url = "jdbc:mysql://localhost:3306/mycompany";
    private static String id;
    private static String password;

    public static void main(String[] args) {
        loadProperties();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            conn = DriverManager.getConnection(url, id, password);

            stmt = conn.createStatement();

            String sql = "SELECT empno, ename, job, sal ";
            sql += "FROM emp ";
            sql += "WHERE sal >= 1500";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                double sal = rs.getDouble("sal");
                System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void loadProperties() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("src/resources/database.properties")) {
            prop.load(fis);
            id = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}