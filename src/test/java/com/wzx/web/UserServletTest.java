package com.wzx.web;

import junit.framework.TestCase;

import java.lang.reflect.Method;

/**
 * else if ...is so boring
 */
public class UserServletTest{

    public void login() {
        System.out.println("login");
    }

    public void register() {
        System.out.println("register");
    }

    public static void main(String[] args) {
        String action = "register";
        try {
            //find string's method
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(declaredMethod);
            //run the method
            declaredMethod.invoke(new UserServletTest());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}