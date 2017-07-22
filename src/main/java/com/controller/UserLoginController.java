package com.controller;

import com.dao.UserDAOImpl;
import com.model.User;
import com.services.PassEnDyService;
import com.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 16-07-2017.
 */@Controller
public class UserLoginController {

    @Autowired
    UserDAOImpl userDao;
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public ModelAndView registration(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = null;
        session=request.getSession(false);

        modelAndView = new ModelAndView("dashboard");
        User user = new User();
        boolean value;
        user.setEmail((request.getParameter("usremail")));
        user.setUsername((request.getParameter("usremail")));
        String encryptedPassword = PassEnDyService.encrypt(request.getParameter("password"));
        user.setPassword(encryptedPassword);

        // calling User service implementation
        value= userService.checkLogin(user);
        if(value==true){
            session.setAttribute("username",request.getParameter("usremail"));
            session.setAttribute("userid",user);
            String email=user.getEmail();
            session.setAttribute("email",email);

            return modelAndView;


    }
    else {
          ModelAndView  modelAndView2 = new ModelAndView("homepage");
          return modelAndView2;

        }
    }

}
