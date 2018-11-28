package com.lesson6.homework6_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.homework6_1.dao.PlaneDAO;
import com.lesson6.homework6_1.model.Plane;
import com.lesson6.homework6_1.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/plane")
public class PlaneController extends GeneralController<Plane>{

    private PlaneDAO planeDAO;
    private PlaneService planeService;

    @Autowired
    public PlaneController(PlaneDAO planeDAO, PlaneService planeService) {
        this.planeDAO = planeDAO;
        this.planeService = planeService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(InputStream dataStream){
        try {
            return "plane saved with id: "+planeService.save(new ObjectMapper().readValue(dataStream, Plane.class)).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(InputStream dataStream){
        try {
            return "flight with id: "+planeService.update(new ObjectMapper().readValue(dataStream, Plane.class)).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            planeDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id", produces = "text/plain")
    public @ResponseBody
    String findById(@RequestParam("id") Long id){
        try {
            return planeDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-old-planes", produces = "text/plain")
    public @ResponseBody
    String oldPlanes(){
        try {
            return parseObjectList(planeDAO.oldPlanes());
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-regular-planes", produces = "text/plain")
    public @ResponseBody
    String regularPlanes(){
        try {
            return parseObjectList(planeDAO.regularPlanes());
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
