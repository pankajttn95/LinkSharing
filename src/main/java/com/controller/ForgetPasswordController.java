package com.controller;

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

/**
 * Created by DELL on 21-07-2017.
 */
@Controller
public class ForgetPasswordController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView changePassword() {
        ModelAndView modelAndView = new ModelAndView("forgetpass");
        return modelAndView;
    }

    @RequestMapping(value = "/changepass",method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request) throws Exception {
        User user=new User();
        String email=request.getParameter("email");
        String encryptedPassword = PassEnDyService.encrypt(request.getParameter("password"));

        user.setEmail(email);
        user.setPassword(encryptedPassword);
        boolean status=userService.passwordChange(user);

        if(status==true)
            return "homepage";
        else
            return "newPass";
    }
    @RequestMapping(value = "/checkemail",method = RequestMethod.POST)
    public String checkEmail(HttpServletRequest request, HttpServletResponse response){
        String email=request.getParameter("email");
        boolean status=userService.emailCheck(email);

        if(status==true)
            return "newPass";
        else
            return "forgetpass";
    }
}