package com.lesson6.homework6_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.Filter;
import com.lesson6.homework6_1.model.Flight;
import com.lesson6.homework6_1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/flight")
public class FlightController extends GeneralController<Flight>{

    private FlightDAO flightDAO;
    private FlightService flightService;

    @Autowired
    public FlightController(FlightDAO flightDAO, FlightService flightService) {
        this.flightDAO = flightDAO;
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "text/plain")
    public @ResponseBody
    String save(InputStream dataStream){
        try {
            return "flight saved with id: "+flightService.save(new ObjectMapper().readValue(dataStream, Flight.class)).getId();
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", produces = "text/plain")
    public @ResponseBody
    String update(InputStream dataStream){
        try {
            return "flight with id: "+flightService.update(new ObjectMapper().readValue(dataStream, Flight.class)).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = "text/plain")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            flightDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id", produces = "text/plain")
    public @ResponseBody
    String findById(@RequestParam("id") Long id){
        try {
            return flightDAO.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-filter", produces = "text/plain")
    public @ResponseBody
    String flightsByDate(InputStream dataStream){
        try {
            return parseObjectList(flightDAO.flightsByDate(new ObjectMapper().readValue(dataStream, Filter.class)));
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-most-popular-to", produces = "text/plain")
    public @ResponseBody
    String mostPopularTo(){
        try {
            return parseObjectList(flightDAO.mostPopularTo());
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-most-popular-from", produces = "text/plain")
    public @ResponseBody
    String mostPopularFrom(){
        try {
            return parseObjectList(flightDAO.mostPopularFrom());
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
