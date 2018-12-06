package com.lesson7.homework7_1.dao;

import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.model.Subcategory;

import java.util.List;

public interface SubcategoryDAO extends GeneralDAO<Subcategory> {

    List<Subcategory> getAll();
    List<Subcategory> getAllByCategory(Category category);

}
