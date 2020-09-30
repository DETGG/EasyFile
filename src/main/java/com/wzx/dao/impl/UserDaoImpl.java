package com.wzx.dao.impl;

import com.wzx.dao.BaseDao;
import com.wzx.dao.UserDao;
import com.wzx.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByID(int id) {
        String sql = "select * from user where id = ?";
        return queryForOne(sql,User.class,id);
    }

    @Override
    public User queryUserByIDAndPassword(int id, String password) {
        String sql = "select * from user where id = ? and password = ?";
        return queryForOne(sql,User.class,id,password);
    }

    @Override
    public int SaveUser(User user) {
        String sql = "insert into user(id,password,username,email) values(?,?,?,?)";
        return update(sql,user.getId(),user.getPassword(),user.getUsername(),user.getEmail());
    }

    @Override
    public User queryUserByEmail(String email) {
        String sql = "select * from user where email= ?";
        return queryForOne(sql,User.class,email);
    }
}
