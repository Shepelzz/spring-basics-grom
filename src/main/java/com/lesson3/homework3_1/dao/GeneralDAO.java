package com.lesson3.homework3_1.dao;

import com.lesson3.homework3_1.exception.InternalServerError;
import com.lesson3.homework3_1.model.Model;
import org.hibernate.SessionFactory;

public interface GeneralDAO<T extends Model> {

    T findById(Long id) throws InternalServerError;
    SessionFactory createSessionFactory();

}
