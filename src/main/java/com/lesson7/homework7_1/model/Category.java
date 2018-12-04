package com.lesson7.homework7_1.model;


import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category extends GeneralModel {

    private Long id;
    private String name;

    @Id
    @SequenceGenerator(name = "CATEGORY_SEQ", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @Column(name = "CATEGORY_ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
