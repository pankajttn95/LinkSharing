/*
package com.controller;

import com.model.MailMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
public class MailSendController {

 @Autowired
    MailMail mailMail;


@RequestMapping(value = "/sendemail", method = RequestMethod.GET)
    public String sendEmail(HttpSession session, HttpServletResponse response, HttpServletRequest request){

    session=request.getSession(false);
    String sender= String.valueOf(session.getAttribute("email"));
    String receiver=request.getParameter("recEmail");
    String subject= "LinkHub: New Invitation Recieved ";
    String message="New Resource";
    mailMail.sendMail(sender,receiver,subject,message);
    return "dashboard";
}


}
*/
