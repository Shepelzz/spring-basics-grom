package com.lesson6.homework6_1.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLANE")
public class Plane extends GeneralModel {

    private Long id;
    private String model;
    private String code;
    private Integer yearProduced;
    private Double avgFuelConsumption;

    @Id
    @SequenceGenerator(name = "PLANE_SEQ", sequenceName = "PLANE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANE_SEQ")
    @Column(name = "PLANE_ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "YEAR_PRODUCED")
    public Integer getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(Integer yearProduced) {
        this.yearProduced = yearProduced;
    }

    @Column(name = "AVG_FUEL_CONSUMPTION")
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
        return Objects.equals(model, plane.model) &&
                Objects.equals(code, plane.code);
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, code);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", yearProduced=" + yearProduced +
                ", avgFuelConsumption=" + avgFuelConsumption +
                '}';
    }
}
