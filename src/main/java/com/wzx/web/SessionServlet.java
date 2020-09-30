package com.wzx.web;

import com.wzx.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * sessions can be save in Server with some inf
 */
public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        boolean isNew = session.isNew();
        String id = session.getId();

        resp.getWriter().write("isNew:"+isNew+"\nid:"+id);
    }

    /**
     * save some inf into session
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key1","value1");
        response.getWriter().write("had save key1:value1");
    }

    /**
     * get some inf from session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("get inf from key1 is "+attribute);
    }

    /**
     * get sessions' default life time
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("default time is "+maxInactiveInterval+" s");
    }

    /**
     * set session life time
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void setSessionLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3);
        response.getWriter().write("session will die in 3 seconds");
    }
    /**
     * let the session time 0
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.getWriter().write("session dead");
    }
}