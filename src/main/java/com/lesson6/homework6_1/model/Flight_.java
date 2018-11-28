package com.lesson6.homework6_1.model;

import com.lesson6.homework6_1.model.Flight;
import com.lesson6.homework6_1.model.Passenger;
import com.lesson6.homework6_1.model.Plane;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Flight.class)
public abstract class Flight_ {
    public static volatile SingularAttribute<Flight, Long> id;
    public static volatile SingularAttribute<Flight, Plane> plane;
    public static volatile SetAttribute<Flight, Passenger> passengers;
    public static volatile SingularAttribute<Flight, Date> dateFlight;
    public static volatile SingularAttribute<Flight, String> cityFrom;
    public static volatile SingularAttribute<Flight, String> cityTo;
}
