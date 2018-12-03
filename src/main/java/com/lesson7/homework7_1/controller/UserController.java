package com.lesson7.homework7_1.controller;

import com.lesson7.homework7_1.model.User;
import com.lesson7.homework7_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User save(){

        return null;
    }

    public User update(){

        return null;
    }

    public void delete(){

    }

    public User findById(){

        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView getAll(Model model){

        User user1 = new User();
        User user2 = new User();

        user1.setId(1L);
        user1.setFirstName("Dodic");
        user1.setLastName("One");
        user1.setUserName("DodicOne");

        user2.setId(2L);
        user2.setFirstName("Ololo");
        user2.setLastName("Two");
        user2.setUserName("OloloTwo");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("users", userList);
        return modelAndView;
    }
}
