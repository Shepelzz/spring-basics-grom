package com.lesson7.homework7_1.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Announcement.class)
public class Announcement_ {
    public static volatile SingularAttribute<Announcement, Long> id;
    public static volatile SingularAttribute<Announcement, String> title;
    public static volatile SingularAttribute<Announcement, String> description;
    public static volatile SingularAttribute<Announcement, Integer> price;
    public static volatile SingularAttribute<Announcement, String> currency;
    public static volatile SingularAttribute<Announcement, Subcategory> subcategory;
    public static volatile SingularAttribute<Announcement, String> city;
    public static volatile SingularAttribute<Announcement, String> phone;
    public static volatile SingularAttribute<Announcement, User> user;
    public static volatile SingularAttribute<Announcement, Date> activeFrom;
    public static volatile SingularAttribute<Announcement, Date> activeTo;
    public static volatile SingularAttribute<Announcement, Date> createDate;





}
