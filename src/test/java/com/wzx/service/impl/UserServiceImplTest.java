package com.wzx.service.impl;

import com.wzx.pojo.User;
import com.wzx.service.UserService;
import junit.framework.TestCase;

public class UserServiceImplTest extends TestCase {

    UserService userService = new UserServiceImpl();

    public void testRegisterUser() {
        userService.registerUser(new User(1000,"20000","3434","ss"));
    }

    public void testLogin() {
        System.out.println(userService.login(new User(1000,"1000","we","df")));
    }

    public void testExistID() {
        System.out.println(userService.existID(1000));
    }
}