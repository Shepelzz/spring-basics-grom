package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.model.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

@Repository
@Transactional
public class PassengerDAOImpl extends GeneralDAOImpl<Passenger> implements PassengerDAO {

    private static final String SQL_REGULAR_PASSENGERS = "SELECT *\n" +
            "FROM PASSENGER\n" +
            "WHERE EXISTS (\n" +
            "    SELECT PASSENGER_ID \n" +
            "    FROM FLIGHT_PASSENGER\n" +
            "    WHERE PASSENGER.ID = FLIGHT_PASSENGER.PASSENGER_ID\n" +
            "    GROUP BY PASSENGER_ID\n" +
            "    HAVING COUNT(FLIGHT_ID) > 1\n" +
            ")";

    @PersistenceContext
    private EntityManager entityManager;

    public PassengerDAOImpl() {
        setClazz(Passenger.class);
    }

    @Override
    public Collection<Passenger> regularPassengers() {
        return (HashSet<Passenger>) entityManager.createNativeQuery(SQL_REGULAR_PASSENGERS, Passenger.class).getResultList();
    }
}
