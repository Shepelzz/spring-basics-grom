package com.lesson6.homework6_1.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "PASSENGER")
public class Passenger extends Model {
    @Id
    @SequenceGenerator(name = "PASSENGER_SEQ", sequenceName = "PASSENGER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSENGER_SEQ")
    @Column(name = "PASSENGER_ID")
    private Long id;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @Column(name = "PASSPORT_CODE")
    private String passportCode;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "passengers")
    private Collection<Flight> flights = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(nationality, passenger.nationality) &&
                Objects.equals(dateOfBirth, passenger.dateOfBirth) &&
                Objects.equals(passportCode, passenger.passportCode) &&
                Objects.equals(flights, passenger.flights);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lastName, nationality, dateOfBirth, passportCode, flights);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth.toString() +
                ", passportCode='" + passportCode + '\'' +
                ", flights=" + flights.toString() +
                '}';
    }
}
