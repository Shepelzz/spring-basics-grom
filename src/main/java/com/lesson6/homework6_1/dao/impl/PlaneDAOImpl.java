package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.PlaneDAO;
import com.lesson6.homework6_1.model.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PlaneDAOImpl extends GeneralDAOImpl<Plane> implements PlaneDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public PlaneDAOImpl() {
        setClazz(Plane.class);
    }

}
