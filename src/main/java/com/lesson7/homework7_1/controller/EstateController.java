package com.lesson7.homework7_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson7.homework7_1.dao.EstateDAO;
import com.lesson7.homework7_1.model.Estate;
import com.lesson7.homework7_1.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/estate")
public class EstateController {

    private EstateService estateService;
    private EstateDAO estateDAO;
    private ObjectMapper objectMapper;

    @Autowired
    public EstateController(EstateService estateService, EstateDAO estateDAO, ObjectMapper objectMapper) {
        this.estateService = estateService;
        this.estateDAO = estateDAO;
        this.objectMapper = objectMapper;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public @ResponseBody
    Estate save(Estate estate/*InputStream dataStream*/){
        try {
            return estateService.save(estate/*objectMapper.readValue(dataStream, User.class)*/);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Estate update(InputStream dataStream){
        try {
            return estateService.update(objectMapper.readValue(dataStream, Estate.class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            estateDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id")
    public @ResponseBody
    Estate findById(@RequestParam("id") Long id){
        try {
            return estateDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
