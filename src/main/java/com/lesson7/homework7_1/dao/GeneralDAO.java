package com.lesson7.homework7_1.dao;

import com.lesson7.homework7_1.model.GeneralModel;

public interface GeneralDAO<T extends GeneralModel> {

    T save(T t);
    T update(T t);
    void delete(Long id);
    T findById(Long id);

}
