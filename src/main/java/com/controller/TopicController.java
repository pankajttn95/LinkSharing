package com.controller;

import com.model.Topic;
import com.model.User;
import com.services.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class TopicController {
    @Autowired
    TopicServiceImpl topicService;
@RequestMapping(value = "/createtopic" , method = RequestMethod.GET)
public String registration(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
    Topic.Visibility visible;
    session=request.getSession(false);

    if (session != null) {
        boolean checkResult;
        Topic topic = new Topic();
        topic.setName(request.getParameter("tname"));
        String visibility = request.getParameter("visibility");
        System.out.println(visibility);

        if (visibility.equals("Public")) {

            visible = Topic.Visibility.Public;
        } else {
            visible = Topic.Visibility.Private;
        }
        topic.setVisibility(visible);

        User user1;
        if (session.getAttribute("userid")!= null  ) {
            user1= (User) session.getAttribute("userid");
        }
        else{
            user1=(User)session.getAttribute("username");
        }
        topic.setCreatedby(user1);

        checkResult = topicService.addTopic(topic);
        if (checkResult == true) {
            return "dashboard";
        } else {

        }


        return "dashboard";
    } else {
        return "homepage";
    }

}
}
