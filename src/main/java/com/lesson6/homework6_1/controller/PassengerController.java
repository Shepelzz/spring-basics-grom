package com.lesson6.homework6_1.controller;

import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/passenger")
public class PassengerController {

    private PassengerDAO passengerDAO;

    @Autowired
    public PassengerController(PassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(Passenger passenger/*InputStream dataStream*/){
        try {
            return "passenger saved with id: "+passengerDAO.save(passenger).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(Passenger passenger/*InputStream dataStream*/){
        try {
            return "flight with id: "+passengerDAO.update(passenger).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String update(Long id/*InputStream dataStream*/){
        try {
            passengerDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = "text/plain")
    public @ResponseBody
    String findById(Long id/*InputStream dataStream*/){
        try {
            return passengerDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
