package com.lesson6.homework6_1.controller;

import com.lesson6.homework6_1.dao.PlaneDAO;
import com.lesson6.homework6_1.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/plane")
public class PlaneController {

    private PlaneDAO planeDAO;

    @Autowired
    public PlaneController(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(Plane plane/*InputStream dataStream*/){
        try {
            return "plane saved with id: "+planeDAO.save(plane).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(Plane plane/*InputStream dataStream*/){
        try {
            return "flight with id: "+planeDAO.update(plane).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String update(Long id/*InputStream dataStream*/){
        try {
            planeDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = "text/plain")
    public @ResponseBody
    String findById(Long id/*InputStream dataStream*/){
        try {
            return planeDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
