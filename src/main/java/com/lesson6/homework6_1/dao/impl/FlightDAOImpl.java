package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.Filter;
import com.lesson6.homework6_1.model.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

@Repository
@Transactional
public class FlightDAOImpl extends GeneralDAOImpl<Flight> implements FlightDAO {

    private static final String SQL_FLIGHTS_BY_DATE = "SELECT * FROM FLIGHT";
    private static final String SQL_MOST_POPULAR_TO =
            "SELECT FLIGHT.*\n" +
            "FROM FLIGHT\n" +
            "LEFT JOIN (\n" +
            "    SELECT CITY_TO, COUNT(FLIGHT_ID) rnk\n" +
            "    FROM FLIGHT\n" +
            "    GROUP BY CITY_TO\n" +
            ") city_rnk ON FLIGHT.CITY_TO = city_rnk.CITY_TO\n" +
            "ORDER BY city_rnk.rnk DESC";
    private static final String SQL_MOST_POPULAR_FROM =
            "SELECT FLIGHT.*\n" +
            "FROM FLIGHT\n" +
            "LEFT JOIN (\n" +
            "    SELECT CITY_FROM, COUNT(FLIGHT_ID) rnk\n" +
            "    FROM FLIGHT\n" +
            "    GROUP BY CITY_FROM\n" +
            ") city_rnk ON FLIGHT.CITY_FROM = city_rnk.CITY_FROM\n" +
            "ORDER BY city_rnk.rnk DESC";

    @PersistenceContext
    private EntityManager entityManager;

    public FlightDAOImpl() {
        setClazz(Flight.class);
    }

    @Override
    public Collection<Flight> flightsByDate(Filter filter) {
       // https://www.ibm.com/developerworks/ru/library/j-typesafejpa/index.html


        return null;//(Collection<Flight>) cb.createQuery(SQL_FLIGHTS_BY_DATE, Flight.class);
    }

    @Override
    public Collection<Flight> mostPopularTo() {
        return (HashSet<Flight>) entityManager.createNativeQuery(SQL_MOST_POPULAR_TO, Flight.class)
                    .setMaxResults(10)
                    .getResultList();
    }

    @Override
    public Collection<Flight> mostPopularFrom() {
        return (HashSet<Flight>) entityManager.createNativeQuery(SQL_MOST_POPULAR_FROM, Flight.class)
                .setMaxResults(10)
                .getResultList();
    }
}

