package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.CategoryDAO;
import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Category save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryDAO.update(category);
    }
}
