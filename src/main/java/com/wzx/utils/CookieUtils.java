package com.wzx.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookies(String name,Cookie[] cookies){
        if(name == null||cookies ==null||0==cookies.length){
            return  null;
        }
        for (Cookie cookie :cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
