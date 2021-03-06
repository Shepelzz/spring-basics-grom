package com.lesson7.homework7_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.model.Filter;
import com.lesson7.homework7_1.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController {

    private AnnouncementService announcementService;
    private AnnouncementDAO announcementDAO;
    private ObjectMapper objectMapper;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, AnnouncementDAO announcementDAO, ObjectMapper objectMapper) {
        this.announcementService = announcementService;
        this.announcementDAO = announcementDAO;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public @ResponseBody
    Announcement save(Announcement announcement/*InputStream dataStream*/){
        try {
            return announcementService.save(announcement/*objectMapper.readValue(dataStream, Announcement.class)*/);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Announcement update(InputStream dataStream){
        try {
            return announcementService.update(objectMapper.readValue(dataStream, Announcement.class));
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

    public List<Announcement> getAnnouncementsByFilter(Filter filter){
        try {
            return announcementDAO.getAnnouncementsByFilter(filter);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
