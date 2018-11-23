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
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
            p1.setLastName("Gosha");
            p1.setNationality("Russia");
            p1.setPassportCode("545");
            p1.setDateOfBirth(makeDate("1995-07-20"));
        Passenger p2 = new Passenger();
            p2.setLastName("Ditto");
            p2.setNationality("US");
            p2.setPassportCode("78RTG54");
            p2.setDateOfBirth(makeDate("1993-11-18"));
        Passenger p3 = new Passenger();
            p3.setLastName("Конь");
            p3.setNationality("UA");
            p3.setPassportCode("ПЕ75555ЩO");
            p3.setDateOfBirth(makeDate("1998-02-14"));
        Passenger p4 = new Passenger();
            p4.setLastName("Пикачу");
            p4.setNationality("UA");
            p4.setPassportCode("ЗЗ11111ЗЗ");
            p4.setDateOfBirth(makeDate("1968-15-18"));
        Passenger p5 = new Passenger();
            p5.setLastName("Рахичу");
            p5.setNationality("UA");
            p5.setPassportCode("ЕЕ778778ГШ");
            p5.setDateOfBirth(makeDate("1985-05-14"));
        Passenger p6 = new Passenger();
            p6.setLastName("Ive");
            p6.setNationality("US");
            p6.setPassportCode("78946");
            p6.setDateOfBirth(makeDate("1971-02-07"));
        Passenger p7 = sPassengerController.findById(6L);
        Passenger p8 = sPassengerController.findById(5L);

        Set<Passenger> passengerList = new HashSet<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));

        Flight flight = new Flight();
            flight.setPlane(sPlaneController.findById(3L));
            for(Passenger p : passengerList)
                flight.getPassengers().add(p);
            flight.setDateFlight(makeDate("2018-10-10"));
            flight.setCityFrom("Prague");
            flight.setCityTo("New-York");

        for(Passenger p : passengerList)
            p.getFlights().add(flight);

        System.out.println(sFlightController.save(flight));

        //System.out.println(sPassengerController.findById(6L));


    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}