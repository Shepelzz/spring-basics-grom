package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.Filter;
import com.lesson6.homework6_1.model.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class FlightDAOImpl extends GeneralDAOImpl<Flight> implements FlightDAO {

    private static final String SQL_FLIGHTS_BY_DATE = "";
    private static final String SQL_MOST_POPULAR_TO = "";
    private static final String SQL_MOST_POPULAR_FROM = "";

    @PersistenceContext
    private EntityManager entityManager;

    public FlightDAOImpl() {
        setClazz(Flight.class);
    }

    @Override
    public Collection<Flight> flightsByDate(Filter filter) {
        return null;
    }

    @Override
    public Collection<Flight> mostPopularTo() {
        return null;
    }

    @Override
    public Collection<Flight> mostPopularFrom() {
        return null;
    }
}
