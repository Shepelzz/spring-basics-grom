package com.lesson7.homework7_1.controller;

import com.lesson7.homework7_1.dao.CategoryDAO;
import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    Category save(@RequestBody Category category){
        try {
            return categoryService.save(category);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public @ResponseBody
    Category update(@RequestBody Category category){
        try {
            return categoryService.update(category);
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