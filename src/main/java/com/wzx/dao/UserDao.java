package com.wzx.dao;

import com.wzx.pojo.User;

public interface UserDao {
    /**
     * search for user inf by id
     * @param id
     * @return null if no such user
     */
    public User queryUserByID(int id);

    /**
     * search for user inf by name and password
     * @param id
     * @param password
     * @return null if password false
     */
    public User queryUserByIDAndPassword(int id,String password);

    /**
     * save the user inf
     * @param user
     * @return false:-1 true:counts of lines changed
     */
    public int SaveUser(User user);

    /**
     * search for user inf by email
     * @param email
     * @return
     */
    public User queryUserByEmail(String email);
}
