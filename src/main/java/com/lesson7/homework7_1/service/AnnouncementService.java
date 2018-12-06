package com.lesson7.homework7_1.service;

import com.lesson7.homework7_1.exception.BadRequestException;
import com.lesson7.homework7_1.model.Announcement;

public interface AnnouncementService {

    Announcement save(Announcement announcement) throws BadRequestException;
    Announcement update(Announcement announcement) throws BadRequestException ;

}
