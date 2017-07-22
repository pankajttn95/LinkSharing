package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DELL on 22-07-2017.
 */
@Controller
public class ProfileController {
    @RequestMapping(value = "/profile" ,method = RequestMethod.GET)
    public String getProfileView(){

        return "profile";
    }
}
