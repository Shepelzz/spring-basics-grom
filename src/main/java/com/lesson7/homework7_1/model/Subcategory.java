package com.lesson7.homework7_1.model;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, category);
    }
}
