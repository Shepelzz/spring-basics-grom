package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.PlaneDAO;
import com.lesson6.homework6_1.model.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class PlaneDAOImpl extends GeneralDAOImpl<Plane> implements PlaneDAO {

    private static final String SQL_OLD_PLANES = "";
    private static final String SQL_REGULAR_PLANES = "";

    @PersistenceContext
    private EntityManager entityManager;

    public PlaneDAOImpl() {
        setClazz(Plane.class);
    }

    @Override
    public Collection<Plane> oldPlanes() {
        return null;
    }

    @Override
    public Collection<Plane> regularPlanes() {
        return null;
    }
}
