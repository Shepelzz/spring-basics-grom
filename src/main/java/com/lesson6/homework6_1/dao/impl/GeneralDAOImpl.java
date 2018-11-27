package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.GeneralDAO;
import com.lesson6.homework6_1.model.Model;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public abstract class GeneralDAOImpl<T extends Model> implements GeneralDAO<T> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
    }

    @Transactional
    @Override
    public T save(T t){
        entityManager.persist(t);
        return t;
    }

    @Transactional
    @Override
    public T update(T t){
        entityManager.merge(t);
        return t;
    }

    @Transactional
    @Override
    public void delete(Long id){
        entityManager.remove(entityManager.find(clazz, id));
    }

    @Override
    public T findById(Long id){
        return entityManager.find(clazz, id);
    }


}
