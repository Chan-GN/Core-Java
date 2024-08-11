package main.java.model;

import java.sql.SQLException;
import java.util.List;

public interface MemoDAO {

    void addMemo(String content) throws SQLException;

    List<Memo> getAllMemos() throws SQLException;

    boolean deleteMemo(int id) throws SQLException;

}