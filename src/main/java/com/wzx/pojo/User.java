package com.wzx.pojo;

import java.util.List;

public class User {
    private Integer id;
    private String password;
    private String username;
    private String email;

    public User(){

    }

    public User(Integer id,String password,String name,String email){
        setEmail(email);
        setId(id);
        setUsername(name);
        setPassword(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
