package com.lesson6.homework6_1.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "FLIGHT")
public class Flight extends Model {
    @Id
    @SequenceGenerator(name = "FLIGHT_SEQ", sequenceName = "FLIGHT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_SEQ")
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name="PLANE_ID", nullable = false)
    private Plane plane;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FLIGHT_PASSENGER", joinColumns = @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID"))
    private Collection<Passenger> passengers;
    @Column(name = "DATE_FLIGHT")
    private Date dateFlight;
    @Column(name = "CITY_FROM")
    private String cityFrom;
    @Column(name = "CITY_TO")
    private String cityTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Collection<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Collection<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }
}
