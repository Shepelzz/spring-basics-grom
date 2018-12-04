package com.lesson7.homework7_1.service;

import com.lesson7.homework7_1.model.Announcement;

public interface AnnouncementService {

    Announcement save(Announcement announcement);
    Announcement update(Announcement announcement);

}
