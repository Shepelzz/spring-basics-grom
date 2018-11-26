package com.lesson6.homework6_1.dao;

import com.lesson6.homework6_1.model.Filter;
import com.lesson6.homework6_1.model.Flight;

import java.util.Collection;

public interface FlightDAO extends GeneralDAO<Flight>{

    Collection<Flight> flightsByDate(Filter filter);
    Collection<Flight> mostPopularTo();
    Collection<Flight> mostPopularFrom();

}
