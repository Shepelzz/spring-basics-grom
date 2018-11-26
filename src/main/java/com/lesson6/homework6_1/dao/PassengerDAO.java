package com.lesson6.homework6_1.dao;

import com.lesson6.homework6_1.model.Passenger;

import java.util.Collection;

public interface PassengerDAO extends GeneralDAO<Passenger>{

    Collection<Passenger> regularPassengers();

}
