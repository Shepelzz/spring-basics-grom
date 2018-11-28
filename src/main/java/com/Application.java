package com;

import com.lesson6.homework6_1.controller.FlightController;
import com.lesson6.homework6_1.controller.PassengerController;
import com.lesson6.homework6_1.controller.PlaneController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    private static EntityManager sEntityManager;
    @PersistenceContext
    private EntityManager entityManager;


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
        Application.sEntityManager = entityManager;
    }



    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

//        Passenger p1 = new Passenger();
//            p1.setLastName("Test");
//            p1.setNationality("US");
//            p1.setPassportCode("456789oi");
//            p1.setDateOfBirth(makeDate("1985-05-21"));
        //Passenger p2 = sPassengerController.findById(25L);

        //Passenger[] passengerList = new Passenger[]{p2};

/*
            Flight flight = new Flight();
            flight.setPlane(sPlaneController.findById(2L));
            for (Passenger p : passengerList)
                flight.getPassengers().add(p);
            flight.setDateFlight(makeDate("2018-01-01"));
            flight.setCityFrom("P3");
            flight.setCityTo("P2");


            for (Passenger p : passengerList) {
                p.getFlights().add(flight);
            }

*/
            //System.out.println(sFlightController.save(flight));

            //System.out.println(sFlightController.update(flight)); //РАБОТАЕТ

            //System.out.println(sPassengerController.findById(6L));

//        Filter filter = new Filter();
//        filter.setCityFrom("Kiev");
//        filter.setCityTo("Chernihiv");
//        filter.setPlaneModel("Boeing 777");
//        filter.setDate(makeDate("2018-01-24"));
//
//        System.out.println("flightsByDate:");
//        Collection<Flight> flights = sFlightController.flightsByDate(filter);
//
//        for(Flight f : flights)
//            System.out.println(f.toString());

//        System.out.println("mostPopularFrom:");
//        for(Flight f : sFlightController.mostPopularFrom())
//            System.out.println(f.toString());
//
//        System.out.println("mostPopularTo:");
//        for(Flight f : sFlightController.mostPopularTo())
//            System.out.println(f.toString());


    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}