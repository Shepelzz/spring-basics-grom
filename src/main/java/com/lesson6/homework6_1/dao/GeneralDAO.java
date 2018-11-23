package com.lesson6.homework6_1.dao;

import com.lesson6.homework6_1.model.Model;

public interface GeneralDAO<T extends Model> {

    T save(T t);
    T update(T t);
    void delete(Long id);
    T findById(Long id);

}
