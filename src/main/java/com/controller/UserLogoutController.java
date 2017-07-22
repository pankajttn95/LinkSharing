package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by DELL on 20-07-2017.
 */
@Controller
public class UserLogoutController {
    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
public String logoutUser(HttpServletRequest request, HttpSession session, HttpServletResponse response){


            session = request.getSession(false);
            session.invalidate();

            return "homepage";

    }
}
