package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.Announcement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnnouncementDAOImpl extends GeneralDAOImpl<Announcement> implements AnnouncementDAO {

    @Override
    public List<Announcement> getTopAnnouncements() {
        return null;
    }

}
