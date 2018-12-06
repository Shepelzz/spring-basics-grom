package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.CategoryDAO;
import com.lesson7.homework7_1.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl extends GeneralDAOImpl<Category> implements CategoryDAO {

    private static final String SQL_GET_ALL_CATEGORIES = "SELECT * FROM CATEGORY";

    public CategoryDAOImpl() {
        setClazz(Category.class);
    }

    public List<Category> getAll(){
        return entityManager.createNativeQuery(SQL_GET_ALL_CATEGORIES, Category.class).getResultList();
    }
}
