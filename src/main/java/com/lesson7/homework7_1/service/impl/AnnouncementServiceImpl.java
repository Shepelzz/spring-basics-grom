package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementDAO announcementDAO;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDAO announcementDAO) {
        this.announcementDAO = announcementDAO;
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementDAO.save(announcement);
    }

    @Override
    public Announcement update(Announcement announcement) {
        return announcementDAO.update(announcement);
    }
}
