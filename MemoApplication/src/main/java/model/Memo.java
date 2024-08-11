package main.java.model;

import java.sql.Timestamp;

public class Memo {

    private final int id;
    private final String content;
    private final Timestamp createdAt;

    public Memo(int id, String content, Timestamp createdAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getContent() {
        return content;
    }

}