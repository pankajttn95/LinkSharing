package com.controller;

import com.dao.UserDaoImpl;
import com.model.User;
import com.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DELL on 16-07-2017.
 */@Controller
public class UserLogin {

    @Autowired
    UserDaoImpl userDao;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = null;


        modelAndView = new ModelAndView("test");
        User user = new User();

        user.setEmail((request.getParameter("usremail")));
        user.setUsername((request.getParameter("usremail")));
        user.setPassword((request.getParameter("password")));
        System.out.println(user.toString());

        // calling User service implementation
        userService.checkLogin(user);
        return modelAndView;


    }

}
