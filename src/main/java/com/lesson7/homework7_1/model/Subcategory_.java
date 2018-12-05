package com.lesson7.homework7_1.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Subcategory.class)
public class Subcategory_ {
    public static volatile SingularAttribute<Subcategory, Long> id;
    public static volatile SingularAttribute<Subcategory, String> name;
    public static volatile SingularAttribute<Subcategory, Category> category;
}
