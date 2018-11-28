package com.lesson6.homework6_1.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Plane.class)
public abstract class Plane_ {
    public static volatile SingularAttribute<Plane, Long> id;
    public static volatile SingularAttribute<Plane, String> model;
    public static volatile SingularAttribute<Plane, String> code;
    public static volatile SingularAttribute<Plane, Integer> yearProduced;
    public static volatile SingularAttribute<Plane, Double> avgFuelConsumption;
}
