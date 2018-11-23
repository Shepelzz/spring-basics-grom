package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.model.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PassengerDAOImpl extends GeneralDAOImpl<Passenger> implements PassengerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public PassengerDAOImpl() {
        setClazz(Passenger.class);
    }

}
