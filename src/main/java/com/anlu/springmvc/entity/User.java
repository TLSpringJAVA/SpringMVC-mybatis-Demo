package com.anlu.springmvc.entity;

import java.io.Serializable;

public class User implements Serializable{
    private String loginname;
    private String password;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
