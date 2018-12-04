package com.lesson7.homework7_1.controller;

import com.lesson7.homework7_1.dao.SubcategoryDAO;
import com.lesson7.homework7_1.model.Subcategory;
import com.lesson7.homework7_1.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/subcategory")
public class SubcategoryController {

    private SubcategoryService subcategoryService;
    private SubcategoryDAO categoryDAO;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService, SubcategoryDAO categoryDAO) {
        this.subcategoryService = subcategoryService;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public @ResponseBody
    Subcategory save(@RequestBody Subcategory subcategory){
        try {
            return subcategoryService.save(subcategory);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Subcategory update(@RequestBody Subcategory subcategory){
        try {
            return subcategoryService.update(subcategory);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public @ResponseBody
    String delete(@RequestParam("id") Long id){
        try {
            categoryDAO.delete(id);
            return "flight with id: "+id+" was deleted";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-by-id")
    public @ResponseBody
    Subcategory findById(@RequestParam("id") Long id){
        try {
            return categoryDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
