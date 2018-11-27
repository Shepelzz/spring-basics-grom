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

        Passenger p7 = new Passenger();
            p7.setLastName("Passenger 7");
            p7.setNationality("Kanada");
            p7.setPassportCode("0000000T11");
            p7.setDateOfBirth(makeDate("1975-11-21"));
        Passenger p8 = new Passenger();
            p8.setLastName("Passenger 8");
            p8.setNationality("China");
            p8.setPassportCode("cucuyte12");
            p8.setDateOfBirth(makeDate("1945-10-20"));
        Passenger p6 = sPassengerController.findById(15L);


        Passenger[] passengerList = new Passenger[]{p6,p7,p8};

        Flight flight = new Flight();
            flight.setPlane(sPlaneController.findById(4L));
            for(Passenger p : passengerList)
                flight.getPassengers().add(p);
            flight.setDateFlight(makeDate("2018-11-27"));
            flight.setCityFrom("Odessa");
            flight.setCityTo("Krakov");

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