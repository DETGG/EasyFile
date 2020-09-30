package com.wzx.service;

import com.wzx.pojo.User;

public interface UserService {
    public void registerUser(User user);
    public User login(User user);
    public boolean existID(int ID);
    public boolean existEmail(String email);
}
