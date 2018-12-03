package com.lesson7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MvcController {
    @RequestMapping(method = RequestMethod.GET, value = "/testMvc")
//    @ResponseBody
    public String testMvc(/*@RequestBody Order order,*/ /*@RequestParam String name, @PathVariable String userId*/){
//        CustomResponse customResponse = new CustomResponse();
//        customResponse.setId(1111L);
        return "home";
    }

}
