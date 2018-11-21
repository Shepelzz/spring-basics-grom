package com.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private DAO dao;

    @Autowired
    public TestController(DAO dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save-item", produces = "text/plain")
    public @ResponseBody
    String saveOrder(){
        L3_Item item = new L3_Item();
        item.setDescription("spfpfpfpfp");
        dao.save(item);
        return "ok";
    }
}
