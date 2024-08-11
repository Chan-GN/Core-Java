package main.java.model;

import main.java.db.DBClose;
import main.java.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemoDAOImpl implements MemoDAO {

    @Override
    public void addMemo(String content) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO memo (content) VALUES (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.executeUpdate();
        } finally {
            DBClose.dbClose(conn, pstmt);
        }
    }

    @Override
    public List<Memo> getAllMemos() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Memo> memos = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT id, content, created_at FROM memo ORDER BY created_at DESC";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Memo memo = new Memo(rs.getInt("id"), rs.getString("content"),
                        rs.getTimestamp("created_at"));

                memos.add(memo);
            }
        } finally {
            DBClose.dbClose(conn, stmt, rs);
        }

        return memos;
    }

    @Override
    public boolean deleteMemo(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM memo WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            return affectedRows > 0;
        } finally {
            DBClose.dbClose(conn, pstmt);
        }
    }

}