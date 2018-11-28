package com.lesson6.homework6_1.service;

import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Plane;

public interface PlaneService {

    Plane save(Plane plane) throws BadRequestException;
    Plane update(Plane plane) throws BadRequestException;
}
