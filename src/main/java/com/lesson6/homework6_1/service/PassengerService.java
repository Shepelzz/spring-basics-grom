package com.lesson6.homework6_1.service;

import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Passenger;

public interface PassengerService {

    Passenger save(Passenger passenger) throws BadRequestException;
    Passenger update(Passenger passenger) throws BadRequestException;
}
