package com.lesson7.homework7_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import com.lesson7.homework7_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;
    private UserDAO userDAO;

    @Autowired
    public UserController(UserService userService, UserDAO userDAO) {
        this.userService = userService;
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public @ResponseBody
    User save(InputStream dataStream){
        try {
            return userService.save(new ObjectMapper().readValue(dataStream, User.class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    User update(InputStream dataStream){
        try {
            return userService.update(new ObjectMapper().readValue(dataStream, User.class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            userDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id")
    public @ResponseBody
    User findById(@RequestParam("id") Long id){
        try {
            return userDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
