package com.lesson7.homework7_1.dao;

import com.lesson7.homework7_1.model.Category;

import java.util.List;

public interface CategoryDAO extends GeneralDAO<Category>{

    List<Category> getAll();

}
