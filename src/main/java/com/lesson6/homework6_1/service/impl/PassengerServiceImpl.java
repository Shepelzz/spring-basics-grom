package com.lesson6.homework6_1.service.impl;

import com.lesson6.homework6_1.dao.PassengerDAO;
import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Passenger;
import com.lesson6.homework6_1.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerDAO passengerDAO;

    @Autowired
    public PassengerServiceImpl(PassengerDAO passengerDAO){
        this.passengerDAO = passengerDAO;
    }

    @Override
    public Passenger save(Passenger passenger) throws BadRequestException{
        passengerValidator(passenger);
        return passengerDAO.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) throws BadRequestException{
        passengerValidator(passenger);
        return passengerDAO.update(passenger);
    }

    private void passengerValidator(Passenger passenger) throws BadRequestException {
        if(passenger.getLastName().equals(""))
            throw new BadRequestException("Passenger last name can not be empty");
        if(passenger.getPassportCode().equals(""))
            throw new BadRequestException("Passenger passportCode can not be empty");
    }
}
