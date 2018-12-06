package com.lesson7.homework7_1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson7.homework7_1.dao.CategoryDAO;
import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryDAO categoryDAO) {
        this.categoryService = categoryService;
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", produces = "application/json")
    public @ResponseBody
    Category save(InputStream dataStream){
        try {
            return categoryService.save(new ObjectMapper().readValue(dataStream, Category.class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Category update(InputStream dataStream){
        try {
            return categoryService.update(new ObjectMapper().readValue(dataStream, Category.class));
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
    Category findById(@RequestParam("id") Long id){
        try {
            return categoryDAO.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
