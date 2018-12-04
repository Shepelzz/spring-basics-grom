package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.SubcategoryDAO;
import com.lesson7.homework7_1.model.Subcategory;
import com.lesson7.homework7_1.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    private SubcategoryDAO subcategoryDAO;

    @Autowired
    public SubcategoryServiceImpl(SubcategoryDAO subcategoryDAO) {
        this.subcategoryDAO = subcategoryDAO;
    }

    @Override
    public Subcategory save(Subcategory subcategory) {
        return subcategoryDAO.save(subcategory);
    }

    @Override
    public Subcategory update(Subcategory subcategory) {
        return subcategoryDAO.update(subcategory);
    }
}
