package com.lesson7.homework7_1.controller;


import com.lesson7.homework7_1.dao.AnnouncementDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class MainController {

    private AnnouncementDAO announcementDAO;

    @Autowired
    public MainController(AnnouncementDAO announcementDAO) {
        this.announcementDAO = announcementDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String findById(@RequestParam("id") Long id){
        try {
            return null;
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
