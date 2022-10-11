package com.example.metalk.Login;

public class Model_Account {
    private String Phone;
    private String Password;

    public Model_Account(String phone, String password) {
        Phone = phone;
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
