package com.lesson6.homework6_1.controller;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/flight")
public class FlightController {

    private FlightDAO flightDAO;

    @Autowired
    public FlightController(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(Flight flight/*InputStream dataStream*/){
        try {
            return "flight saved with id: "+flightDAO.save(flight).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(Flight flight/*InputStream dataStream*/){
        try {
            return "flight with id: "+flightDAO.update(flight).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String update(Long id/*InputStream dataStream*/){
        try {
            flightDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = "text/plain")
    public @ResponseBody
    String findById(Long id/*InputStream dataStream*/){
        try {
            return flightDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
