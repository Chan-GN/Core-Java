package main.java.controller;

import com.google.gson.Gson;
import main.java.model.Memo;
import main.java.model.MemoDAO;
import main.java.model.MemoDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/api/memos/*")
public class MemoController extends HttpServlet {

    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String ENCODING_UTF8 = "UTF-8";
    private static final String CORS_ORIGIN = "http://localhost";
    private static final String CORS_METHODS = "GET, POST, PUT, DELETE, OPTIONS";
    private static final String CORS_HEADERS = "Content-Type";
    private static final String CORS_MAX_AGE = "3600";
    private MemoDAO memoDAO;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        memoDAO = new MemoDAOImpl();
        gson = new Gson();
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCommonResponseHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setCommonResponseHeaders(resp);

        try {
            List<Memo> memos = memoDAO.getAllMemos();
            String json = gson.toJson(memos);
            resp.getWriter().write(json);
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write(gson.toJson("Error fetching memos: " + e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setCommonResponseHeaders(resp);

        String content = req.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        Memo newMemo = gson.fromJson(content, Memo.class);

        try {
            memoDAO.addMemo(newMemo.getContent());
            resp.getWriter().write(gson.toJson("Memo added successfully"));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write(gson.toJson("Error adding memo: " + e.getMessage()));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setCommonResponseHeaders(resp);

        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(gson.toJson("Invalid memo ID"));
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(gson.toJson("Invalid memo ID"));
            return;
        }

        try {
            int memoId = Integer.parseInt(splits[1]);
            boolean deleted = memoDAO.deleteMemo(memoId);
            if (deleted) {
                resp.getWriter().write(gson.toJson("Memo deleted successfully"));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write(gson.toJson("Memo not found"));
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write(gson.toJson("Invalid memo ID"));
        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write(gson.toJson("Error deleting memo: " + e.getMessage()));
        }
    }

    // CORS 헤더와 응답 설정을 위한 공통 메서드
    private void setCommonResponseHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", CORS_ORIGIN);
        resp.setHeader("Access-Control-Allow-Methods", CORS_METHODS);
        resp.setHeader("Access-Control-Allow-Headers", CORS_HEADERS);
        resp.setHeader("Access-Control-Max-Age", CORS_MAX_AGE);
        resp.setContentType(CONTENT_TYPE_JSON);
        resp.setCharacterEncoding(ENCODING_UTF8);
    }

}