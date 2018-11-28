package com.lesson6.homework6_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.model.Passenger;
import com.lesson6.homework6_1.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/passenger")
public class PassengerController extends GeneralController<Passenger>{

    private PassengerDAO passengerDAO;
    private PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerDAO passengerDAO, PassengerService passengerService) {
        this.passengerDAO = passengerDAO;
        this.passengerService = passengerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(InputStream dataStream){
        try {
            return "passenger saved with id: "+passengerService.save(new ObjectMapper().readValue(dataStream, Passenger.class)).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(InputStream dataStream){
        try {
            return "flight with id: "+passengerService.update(new ObjectMapper().readValue(dataStream, Passenger.class)).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            passengerDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id", produces = "text/plain")
    public @ResponseBody
    String findById(@RequestParam("id") Long id){
        try {
            return passengerDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-regular-passengers", produces = "text/plain")
    public @ResponseBody
    String regularPassengers(){
        try {
            return parseObjectList(passengerDAO.regularPassengers());
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
