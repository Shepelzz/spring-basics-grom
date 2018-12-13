package com.lesson7.homework7_1.model;

import javax.persistence.*;

@Entity
@Table(name = "ESTATE")
public class Estate extends GeneralModel {
    private Long id;
    private String address;

    @Id
    @SequenceGenerator(name = "ESTATE_SEQ", sequenceName = "ESTATE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTATE_SEQ")
    @Column(name = "ESTATE_ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
