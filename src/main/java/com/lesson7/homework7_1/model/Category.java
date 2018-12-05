package com.lesson7.homework7_1.model;


import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
