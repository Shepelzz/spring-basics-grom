package com.lesson2.homework2_2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson2.homework2_2.model.L2hw2_Item;
import com.lesson2.homework2_2.service.L2Hw2_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;


@Controller
public class L2hw2_ItemController {

    private L2Hw2_ItemService itemService;

    @Autowired
    public L2hw2_ItemController(L2Hw2_ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemTest", produces = "text/plan")
    public @ResponseBody
    String test() {
        return "Test";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/itemSave", produces = "text/plan")
    public @ResponseBody
    String save(InputStream dataStream) {
        try {
            return "Item saved with id: " + itemService.save(new ObjectMapper().readValue(dataStream, L2hw2_Item.class)).getId();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/itemUpdate", produces = "text/plan")
    public @ResponseBody
    String update(InputStream dataStream) {
        try {
            return "Item with id: "+itemService.update(new ObjectMapper().readValue(dataStream, L2hw2_Item.class)).getId()+" was updated";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/itemDelete", produces = "text/plan")
    public @ResponseBody
    String delete(@RequestParam("id") Long id) {
        try{
            return "Item with id: "+itemService.delete(id).getId()+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemGet", produces = "text/plan")
    public @ResponseBody
    String findById(@RequestParam("id") Long id) {
        try{
            return itemService.findById(id).toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
