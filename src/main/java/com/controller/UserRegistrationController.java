package com.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoImpl;
import com.model.User;
import com.services.PassEnDyService;
import com.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


/**
 * Created by root on 13/7/17.
 */


@Controller
public class UserRegistrationController {


    @Autowired
    UserDaoImpl userDao;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView start_loginpage()
    {
        ModelAndView modelAndView = new ModelAndView("User");
        return modelAndView;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ModelAndView registration(/*@RequestParam("file")*/ HttpServletRequest request, HttpServletResponse response) throws Exception {



        ModelAndView modelAndView = null;
                boolean check;
       // System.out.println("file size ...."+fileupload.getSize());
                User user = new User();
                user.setFname((request.getParameter("fname")));
                user.setLname((request.getParameter("lname")));
                user.setEmail((request.getParameter("email")));
                user.setUsername((request.getParameter("username")));
                String encryptedPassword = PassEnDyService.encrypt(request.getParameter("password"));
                user.setPassword(encryptedPassword);
        // userService.userImageUpload(fileupload, user);

        java.util.Date today = new java.util.Date();
                user.setDateCreated(new java.sql.Timestamp(today.getTime()));
                user.setActive(true);
                user.setAdmin(false);
                System.out.println(user.toString());

              // calling User service implementation
                check=userService.addUser(user);
                if (check==true) {
                    modelAndView = new ModelAndView("dashboard");
                    return modelAndView;
                }
                else{
                    System.out.println("Server experienced some sort of error .");

                }
        modelAndView = new ModelAndView("User");
       return modelAndView;
    }
    @RequestMapping(value = "/forgetpassword" , method = RequestMethod.GET)
    public ModelAndView forgetpass()
    {
        ModelAndView modelAndView = new ModelAndView("User");
        return modelAndView;
    }

}
