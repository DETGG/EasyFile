package com.wzx.dao;

import com.wzx.dao.impl.UserDaoImpl;
import com.wzx.pojo.User;
import junit.framework.TestCase;
import org.junit.Test;

public class UserDaoTest extends TestCase {
    UserDao userDao = new UserDaoImpl();
    User user;

    public void testQueryUserByID() {
        user = userDao.queryUserByID(1000);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("no such a user");
        }
    }

    public void testQueryUserByIDAndPassword() {
        user = userDao.queryUserByIDAndPassword(1001, "1001");
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("no such a user");
        }
    }

    public void testSaveUser() {
        userDao.SaveUser(new User(11, "s324", "wzx", "wq4@11.com"));
    }

    public void testQueryUserByEmail(){
        user = userDao.queryUserByEmail("15815179079@163.com");
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("no such a user");
        }
    }
}