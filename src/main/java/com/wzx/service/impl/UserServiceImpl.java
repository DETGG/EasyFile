package com.wzx.service.impl;

import com.wzx.dao.UserDao;
import com.wzx.dao.impl.UserDaoImpl;
import com.wzx.pojo.User;
import com.wzx.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.SaveUser(user);
    }

    /**
     * login
     * @param user
     * @return null:false
     */
    @Override
    public User login(User user) {
        return userDao.queryUserByIDAndPassword(user.getId(),user.getPassword());
    }

    @Override
    public boolean existID(int ID) {
        if(userDao.queryUserByID(ID)==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean existEmail(String email) {
        if(userDao.queryUserByEmail(email)==null){
            return false;
        }
        return true;
    }
}
