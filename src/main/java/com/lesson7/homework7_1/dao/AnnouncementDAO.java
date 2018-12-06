package com.lesson7.homework7_1.dao;

import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.model.Filter;

import java.util.List;

public interface AnnouncementDAO extends GeneralDAO<Announcement> {

    List<Announcement> getAnnouncementsByFilter(Filter filter);
    List<Announcement> getTopAnnouncements();


}
