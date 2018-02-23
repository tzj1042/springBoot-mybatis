package com.example.demo.model;

public class User {
    private Integer id;

    private String userName;

    private String password;

    private String phone;

    public User(Integer id, String userName, String password, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}