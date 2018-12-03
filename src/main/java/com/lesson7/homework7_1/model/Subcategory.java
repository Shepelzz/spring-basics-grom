package com.lesson7.homework7_1.model;

import com.lesson6.homework6_1.model.GeneralModel;

import javax.persistence.*;

@Entity
@Table(name = "SUBCATEGORY")
public class Subcategory extends GeneralModel {

    private Long id;
    private String name;
    private Category category;

    @Id
    @SequenceGenerator(name = "SUBCATEGORY_SEQ", sequenceName = "SUBCATEGORY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBCATEGORY_SEQ")
    @Column(name = "SUBCATEGORY_ID")
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

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
