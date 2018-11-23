package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FlightDAOImpl extends GeneralDAOImpl<Flight> implements FlightDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public FlightDAOImpl() {
        setClazz(Flight.class);
    }


}
