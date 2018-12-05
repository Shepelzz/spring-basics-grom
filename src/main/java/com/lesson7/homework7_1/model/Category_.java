package com.lesson7.homework7_1.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public class Category_ {

    public static volatile SingularAttribute<Category, Long> id;
    public static volatile SingularAttribute<Category, String> name;
}
