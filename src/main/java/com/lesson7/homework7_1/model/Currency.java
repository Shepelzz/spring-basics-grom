package com.lesson7.homework7_1.model;

import com.lesson6.homework6_1.model.GeneralModel;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY")
public class Currency extends GeneralModel {

    private Long id;
    private String currency;

    @Id
    @SequenceGenerator(name = "CURRENCY_SEQ", sequenceName = "CURRENCY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY_SEQ")
    @Column(name = "CURRENCY_ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
