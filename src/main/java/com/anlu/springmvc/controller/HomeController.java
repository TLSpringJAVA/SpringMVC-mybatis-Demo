package com.anlu.springmvc.controller;

import com.anlu.springmvc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    //添加一个日志
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping(value = "/")
    public String root(){
        logger.info("访问网站了");
        return "index";
    }

    //映射一个action
    @RequestMapping("/index")
    public String index(){
      //输出日志文件
        logger.info("the first jsp pages");
        return "index";
    }


    @RequestMapping(value = "/hello")
    public ModelAndView visit(){

        logger.info("请求visit方法了");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","Hello world");
        //设置逻辑视图名字
        mv.setViewName("message");
        return mv;
    }

    @ModelAttribute
    public void userMode(String loginname, String pwd, Model model){
    logger.info("usermodel");
    //创建user对象并且存储到model中

        User user = new User();
        user.setLoginname(loginname);
        user.setPassword(pwd);
        model.addAttribute("user",user);
    }

    @RequestMapping(value = "/login1")
    public String login(Model model){
        logger.info("login");
        User user = (User) model.asMap().get("user");
        System.out.println(user);
        user.setLoginname("测试->张三");
        return "home/login1";
    }

}
