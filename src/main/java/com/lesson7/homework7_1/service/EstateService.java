package com.lesson7.homework7_1.service;

import com.lesson7.homework7_1.exception.BadRequestException;
import com.lesson7.homework7_1.model.Estate;

public interface EstateService {

    Estate save(Estate estate) throws BadRequestException;
    Estate update(Estate estate) throws BadRequestException;

}
