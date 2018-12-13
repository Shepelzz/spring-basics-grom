package com.lesson7.homework7_1.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ANNOUNCEMENT")
public class Announcement extends GeneralModel {

    private Long id;
    private String title;
    private String description;
    private Integer price;
    private String currency;
    private Category category;
    private Subcategory subcategory;
    private String city;
    private String phone;
    private User user;
    private Estate estate;
    private Date activeFrom;
    private Date activeTo;
    private Date createDate;

    @Id
    @SequenceGenerator(name = "ANNOUNCEMENT_SEQ", sequenceName = "ANNOUNCEMENT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANNOUNCEMENT_SEQ")
    @Column(name = "ANNOUNCEMENT_ID")
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "CURRENCY")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Enumerated(EnumType.STRING)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name="ESTATE_ID", nullable = false)
    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    @Column(name = "ACTIVE_FROM")
    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    @Column(name = "ACTIVE_TO")
    public Date getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(Date activeTo) {
        this.activeTo = activeTo;
    }

    @Column(name = "CREATE_DATE")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(currency, that.currency) &&
                category == that.category &&
                subcategory == that.subcategory &&
                Objects.equals(city, that.city) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(user, that.user) &&
                Objects.equals(estate, that.estate) &&
                Objects.equals(activeFrom, that.activeFrom) &&
                Objects.equals(activeTo, that.activeTo) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, price, currency, category, subcategory, city, phone, user, estate, activeFrom, activeTo, createDate);
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", category=" + category.toString() +
                ", subcategory=" + subcategory.toString() +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", user=" + user.getId() +
                ", activeFrom=" + activeFrom.toString() +
                ", activeTo=" + activeTo.toString() +
                ", createDate=" + createDate.toString() +
                '}';
    }
}
