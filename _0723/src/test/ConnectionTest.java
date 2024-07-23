import main.java.DBClose;
import main.java.DBConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {

    private Connection conn;

    @BeforeEach
    void init() {
        DBConnection dbConnection = new DBConnection();
        this.conn = dbConnection.getConnection();
    }

    @Test
    void test() {
        assertNotNull(conn);
    }

    @AfterEach
    void close() {
        DBClose.dbClose(conn);
    }

}
