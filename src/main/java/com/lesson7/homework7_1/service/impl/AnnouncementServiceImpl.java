package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.exception.BadRequestException;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.security.UserSession;
import com.lesson7.homework7_1.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementDAO announcementDAO;
    private UserSession userSession;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDAO announcementDAO, UserSession userSession) {
        this.announcementDAO = announcementDAO;
        this.userSession = userSession;
    }

    @Override
    @Transactional
    public Announcement save(Announcement announcement) throws BadRequestException {
        userSession.checkAuthorization();
        validation(announcement);
        return announcementDAO.save(announcement);
    }

    @Override
    @Transactional
    public Announcement update(Announcement announcement) throws BadRequestException {
        validation(announcement);
        userSession.checkAuthorization();
        return announcementDAO.update(announcement);
    }

    private void validation(Announcement announcement) throws BadRequestException{
        if(announcement.getTitle().equals("") || announcement.getCity().equals("") || announcement.getCurrency().equals("") || announcement.getDescription().equals(""))
            throw new BadRequestException("fields can not be empty");
        if(announcement.getDescription().length() > 200)
            throw new BadRequestException("description can not be larger than 200 symbols");
    }
}
