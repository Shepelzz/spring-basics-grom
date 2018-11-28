package com.lesson6.homework6_1.service.impl;

import com.lesson6.homework6_1.dao.FlightDAO;
import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Flight;
import com.lesson6.homework6_1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightDAO flightDAO;

    @Autowired
    public FlightServiceImpl(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public Flight save(Flight flight) throws BadRequestException {
        passengerValidator(flight);
        return flightDAO.save(flight);
    }

    @Override
    public Flight update(Flight flight) throws BadRequestException {
        passengerValidator(flight);
        return flightDAO.update(flight);
    }

    private void passengerValidator(Flight flight) throws BadRequestException {

        if(flight.getPlane().getId() == null)
            throw new BadRequestException("Flight plane must be chosen");
        if(flight.getDateFlight() == null)
            throw new BadRequestException("Flight date must be chosen");
        if(flight.getCityFrom().equals(""))
            throw new BadRequestException("Flight city from can not be empty");
        if(flight.getCityTo().equals(""))
            throw new BadRequestException("Flight city to can not be empty");
    }
}
