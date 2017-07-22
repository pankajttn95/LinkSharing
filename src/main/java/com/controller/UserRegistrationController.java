package com.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAOImpl;
import com.model.User;
import com.services.PassEnDyService;
import com.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by root on 13/7/17.
 */


@Controller
public class UserRegistrationController {

    @Autowired
    UserDAOImpl userDao;
    @Autowired
    UserServiceImpl userService;
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public ModelAndView start_loginpage()
    {
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ModelAndView registration(/*@RequestParam("file") CommonsMultipartFile file*/ HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

        session=request.getSession(false);


        ModelAndView modelAndView = null;
                boolean check;
                User user = new User();
                /*byte[] photo=null;
                    if(!file.isEmpty())
                            photo=file.getBytes();
                    user.setPhoto(photo);*/
                user.setFname((request.getParameter("fname")));
                user.setLname((request.getParameter("lname")));
                user.setEmail((request.getParameter("email")));
                user.setUsername((request.getParameter("username")));
                String encryptedPassword = PassEnDyService.encrypt(request.getParameter("password"));
                user.setPassword(encryptedPassword);

        java.util.Date today = new java.util.Date();
                user.setDateCreated(new java.sql.Timestamp(today.getTime()));
                user.setActive(true);
                user.setAdmin(false);

              // calling User service implementation
                check=userService.addUser(user);
                if (check==true) {
                    session.setAttribute("user",request.getParameter("username") );
                    session.setAttribute("userid",user);
                    String email= request.getParameter("email");
                    session.setAttribute("email",email);
                    modelAndView = new ModelAndView("dashboard");
                    return modelAndView;
                }
                else{
                    System.out.println("Server experienced some sort of error .");

                }
        modelAndView = new ModelAndView("homepage");
       return modelAndView;
    }
    @RequestMapping(value = "/forgetpassword" , method = RequestMethod.GET)
    public ModelAndView forgetpass()
    {
        ModelAndView modelAndView = new ModelAndView("homepage");
        return modelAndView;
    }


}
