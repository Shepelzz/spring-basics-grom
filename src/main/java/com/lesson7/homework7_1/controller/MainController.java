package com.lesson7.homework7_1.controller;


import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private AnnouncementDAO announcementDAO;
    private UserSession userSession;

    @Autowired
    public MainController(AnnouncementDAO announcementDAO, UserSession userSession) {
        this.announcementDAO = announcementDAO;
        this.userSession = userSession;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public @ResponseBody
    List<Announcement> getTopAnnouncements(){
        try {
            return announcementDAO.getTopAnnouncements();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public @ResponseBody
    String login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        try {
            userSession.login(userName, password);
            return "User loged in";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public @ResponseBody
    String logout(){
        try {
            userSession.logout();
            return "User loged out";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
