package com.wzx.web;

import com.wzx.utils.CookieUtils;
import com.wzx.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookies can be save in Browser with some inf
 */
public class CookieServlet extends BaseServlet {

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        Cookie iWantCookie = CookieUtils.findCookies("key2",cookies);
        if(null!=iWantCookie){
            resp.getWriter().write("we find the Cookie which name is key2");
        }
    }

    /**
     * create the cookie
     * Request Headers ->Cookie: + key=value
     * Response Headers ->Set-Cookie:key=value
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key2","value2");
        resp.addCookie(cookie);
        resp.getWriter().write("create cookie success");
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookies("key2",req.getCookies());
        cookie.setValue("newValue2");
        resp.addCookie(cookie);
        resp.getWriter().write("the cookie has been renew");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("de","de");
        cookie.setMaxAge(60*60*24*7);//set time:one week
        resp.addCookie(cookie);
        resp.getWriter().write("the cookie's life has been renew");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookies("key1", req.getCookies());
        if (null != cookie) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("the cookie has been deleted");
        }
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        cookie.setPath(req.getContextPath()+"/pages");
        resp.addCookie(cookie);
        resp.getWriter().write("the cookie's path has been changed");
    }

}
