package com.anlu.springmvc.controller;

import com.anlu.springmvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static List<User> userlist;

    public LoginController() {
        super();
        userlist = new ArrayList<User>();
    }

    /**
     * Get请求
     * 请求路径 http://localhost:8080/user/register?loginname=12&password=ee&username=22
     * @param loginnanme
     * @param password
     * @param username
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(
            @RequestParam("loginname") String loginnanme,
            @RequestParam("password") String password,
            @RequestParam("username") String username
    ){
        logger.info("register post 方法被调用了");
        User user = new User();
        user.setLoginname(loginnanme);
        user.setPassword(password);
        user.setUsername(username);

        userlist.add(user);
        return "login/loginForm";

    }
}
