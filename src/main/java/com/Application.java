package com;

import com.lesson6.homework6_1.controller.FlightController;
import com.lesson6.homework6_1.controller.PassengerController;
import com.lesson6.homework6_1.controller.PlaneController;
import com.lesson6.homework6_1.model.Flight;
import com.lesson6.homework6_1.model.Passenger;
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
            p1.setLastName("Test person");
            p1.setNationality("UA");
            p1.setPassportCode("TT666666TT");
            p1.setDateOfBirth(makeDate("1991-14-20"));
        Passenger p2 = sPassengerController.findById(28L);
        Passenger p3 = sPassengerController.findById(6L);

        Passenger[] passengerList = new Passenger[]{p1,p2,p3};

        Flight flight = new Flight();
            flight.setPlane(sPlaneController.findById(4L));
            for(Passenger p : passengerList)
                flight.getPassengers().add(p);
            flight.setDateFlight(makeDate("2018-11-26"));
            flight.setCityFrom("P1");
            flight.setCityTo("P2");

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