package com.wzx.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("UTF-8");//Server's encoding support Chinese
//        resp.setHeader("Content-Type","text/html;charset=utf-8");//Browser's  encoding support Chinese
        resp.setContentType("text/html;charset=utf-8");//Server and Browser set encoding
        PrintWriter writer = resp.getWriter();
        writer.write("response's content!!!");
//        resp.getOutputStream(); //only one IOStream
        try {
            Thread.sleep(5000);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//        ask for redirect
        resp.sendRedirect("/");
    }
}
