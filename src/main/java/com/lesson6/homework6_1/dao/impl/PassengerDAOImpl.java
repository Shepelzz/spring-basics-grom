package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.model.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public class PassengerDAOImpl extends GeneralDAOImpl<Passenger> implements PassengerDAO {

    private static final String SQL_REGULAR_PASSENGERS = "SELECT *\n" +
            "FROM PASSENGER\n" +
            "WHERE EXISTS (\n" +
            "    SELECT  *\n" +
            "    FROM    FLIGHT_PASSENGER fp\n" +
            "       JOIN FLIGHT f ON fp.FLIGHT_ID = f.FLIGHT_ID\n" +
            "    WHERE fp.PASSENGER_ID = PASSENGER.PASSENGER_ID\n" +
            "    GROUP BY fp.PASSENGER_ID, EXTRACT(YEAR FROM f.DATE_FLIGHT)\n" +
            "    HAVING COUNT(DISTINCT f.FLIGHT_ID) >= 25" +
            ")";

    @PersistenceContext
    private EntityManager entityManager;

    public PassengerDAOImpl() {
        setClazz(Passenger.class);
    }

    @Override
    public Collection<Passenger> regularPassengers() {
        return (List<Passenger>) entityManager.createNativeQuery(SQL_REGULAR_PASSENGERS, Passenger.class).getResultList();
    }
}
