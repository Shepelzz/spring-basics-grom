package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = cb.createQuery(Flight.class);
        Root<Flight> flightRoot = criteriaQuery.from(Flight.class);
        Join<Flight, Plane> planes = flightRoot.join(Flight_.plane);

        criteriaQuery.select(flightRoot);

        Predicate criteria = cb.conjunction();
        //CityFrom
        if(filter.getCityFrom() != null)
            criteria = cb.and(criteria, cb.equal(flightRoot.get(Flight_.cityFrom), filter.getCityFrom()));
        //CityTo
        if(filter.getCityTo() != null)
            criteria = cb.and(criteria, cb.equal(flightRoot.get(Flight_.cityTo), filter.getCityTo()));
        //Dates
        if(filter.getDateFrom() != null && filter.getDateTo() != null)
            criteria = cb.and(criteria, cb.between(flightRoot.get(Flight_.dateFlight), filter.getDateFrom(), filter.getDateTo()));
        //Plane
        if(filter.getPlaneModel() != null)
            criteria = cb.and(criteria, cb.equal(planes.get(Plane_.model), filter.getPlaneModel()));

        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Collection<Flight> mostPopularTo() {
        return (List<Flight>) entityManager.createNativeQuery(SQL_MOST_POPULAR_TO, Flight.class)
                .setMaxResults(10)
                .getResultList();
    }

    @Override
    public Collection<Flight> mostPopularFrom() {
        return (List<Flight>) entityManager.createNativeQuery(SQL_MOST_POPULAR_FROM, Flight.class)
                .setMaxResults(10)
                .getResultList();
    }
}

