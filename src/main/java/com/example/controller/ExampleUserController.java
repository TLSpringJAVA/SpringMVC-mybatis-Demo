package com.example.controller;

import com.example.dao.entity.User;
import com.example.service.ExampleUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/testuser")
public class ExampleUserController {
    private static final Logger logger = LoggerFactory.getLogger(ExampleUserController.class);

    @Autowired
    private ExampleUserService exampleUserService;

    @RequestMapping(value = "findAll")
    public ModelAndView getUser1(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> list = exampleUserService.findAllUser();
        //将得到的用户内容放到modelAndView中
        modelAndView.addObject("users",list);
        logger.info("成功得到用户列表");
        modelAndView.setViewName("getUsers");
        return modelAndView;
    }

}
