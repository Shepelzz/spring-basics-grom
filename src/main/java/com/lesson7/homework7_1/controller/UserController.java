package com.lesson7.homework7_1.controller;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import com.lesson7.homework7_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public //@ResponseBody
    User save(User user){
        try {
            return userService.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public //@ResponseBody
    User update(User user){
        try {
            return userService.update(user);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public //@ResponseBody
    String delete(Long id){
        try {
            userDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id")
    public //@ResponseBody
    User findById(Long id){
        try {
            return userDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
