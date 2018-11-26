package com;

import com.lesson6.homework6_1.controller.FlightController;
import com.lesson6.homework6_1.controller.PassengerController;
import com.lesson6.homework6_1.controller.PlaneController;
import com.lesson6.homework6_1.model.Flight;
import com.lesson6.homework6_1.model.Passenger;
import com.lesson6.homework6_1.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@SpringBootApplication
public class Application {

    private static FlightController sFlightController;
    private FlightController flightController;
    private static PlaneController sPlaneController;
    private PlaneController planeController;
    private static PassengerController sPassengerController;
    private PassengerController passengerController;

    @Autowired
    public Application(FlightController fc, PlaneController pc, PassengerController psc) {
        this.flightController = fc;
        this.planeController = pc;
        this.passengerController = psc;
    }

    @PostConstruct
    public void init(){
        Application.sFlightController = flightController;
        Application.sPlaneController = planeController;
        Application.sPassengerController = passengerController;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        Passenger p1 = new Passenger();
            p1.setLastName("Passenger 1");
            p1.setNationality("UA");
            p1.setPassportCode("345345df");
            p1.setDateOfBirth(makeDate("1991-06-01"));
        Passenger p2 = new Passenger();
            p2.setLastName("Passenger 2");
            p2.setNationality("UA");
            p2.setPassportCode("TT666666TT");
            p2.setDateOfBirth(makeDate("1999-12-20"));
        Passenger p3 = new Passenger();
            p3.setLastName("Passenger 3");
            p3.setNationality("UA");
            p3.setPassportCode("45sdsf");
            p3.setDateOfBirth(makeDate("1987-04-10"));
//        Passenger p2 = sPassengerController.findById(28L);
//        Passenger p3 = sPassengerController.findById(6L);

        Passenger[] passengerList = new Passenger[]{p1,p2,p3};

        Flight flight = new Flight();
            flight.setPlane(sPlaneController.findById(3L));
            for(Passenger p : passengerList)
                flight.getPassengers().add(p);
            flight.setDateFlight(makeDate("2018-11-26"));
            flight.setCityFrom("Kiev");
            flight.setCityTo("Kharkiv");

        for(Passenger p : passengerList)
            p.getFlights().add(flight);


        System.out.println(sFlightController.save(flight)); //РУГАЕТСЯ
        //System.out.println(sFlightController.update(flight)); //РАБОТАЕТ

        //System.out.println(sPassengerController.findById(6L));

    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}