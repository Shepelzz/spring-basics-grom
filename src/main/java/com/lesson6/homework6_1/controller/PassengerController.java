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


    public Passenger findById(Long id){
        return passengerDAO.findById(id);
    }
}
