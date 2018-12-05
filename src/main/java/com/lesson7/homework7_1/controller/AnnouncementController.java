package com.lesson7.homework7_1.controller;

import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.model.Filter;
import com.lesson7.homework7_1.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController {

    private AnnouncementService announcementService;
    private AnnouncementDAO announcementDAO;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, AnnouncementDAO announcementDAO) {
        this.announcementService = announcementService;
        this.announcementDAO = announcementDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public @ResponseBody
    Announcement save(@RequestBody Announcement announcement){
        try {
            return announcementService.save(announcement);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Announcement update(@RequestBody Announcement announcement){
        try {
            return announcementService.update(announcement);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            announcementDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id")
    public @ResponseBody
    Announcement findById(@RequestParam("id") Long id){
        try {
            return announcementDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Announcement> getTopAnnouncements(Filter filter){
        try {
            return announcementDAO.getTopAnnouncements(filter);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
