package com.lesson6.homework6_1.service;

import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Flight;

public interface FlightService {

    Flight save(Flight flight) throws BadRequestException;
    Flight update(Flight flight) throws BadRequestException;
}
