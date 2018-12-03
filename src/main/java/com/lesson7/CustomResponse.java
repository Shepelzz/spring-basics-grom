package com.lesson7;

import java.util.Date;

public class CustomResponse {
    private Long id;
    private Long timePassed;
    private Date date;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(Long timePassed) {
        this.timePassed = timePassed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
