package com.lesson6.homework6_1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLANE")
public class Plane extends Model{
    @Id
    @SequenceGenerator(name = "PLANE_SEQ", sequenceName = "PLANE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANE_SEQ")
    @Column(name = "ID")
    private Long id;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "CODE")
    private String code;
    @Column(name = "YEAR_PRODUCED")
    private int yearProduced;
    @Column(name = "AVG_FUEL_CONSUMPTION")
    private Double avgFuelConsumption;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(int yearProduced) {
        this.yearProduced = yearProduced;
    }

    public Double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setAvgFuelConsumption(Double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id) &&
                Objects.equals(model, plane.model) &&
                Objects.equals(code, plane.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, model, code);
    }
}
