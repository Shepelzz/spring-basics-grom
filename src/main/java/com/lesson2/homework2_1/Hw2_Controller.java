package com.lesson2.homework2_1;


import com.lesson2.homework2_1.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Hw2_Controller {
    @Autowired
    Route route;

    @RequestMapping(method = RequestMethod.GET, value = "/hw2_1_test", produces = "text/plan")
    public @ResponseBody
    String callByBean() {
        try {
            return route.toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
