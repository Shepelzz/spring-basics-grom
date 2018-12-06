package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.AnnouncementDAO;
import com.lesson7.homework7_1.model.*;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class AnnouncementDAOImpl extends GeneralDAOImpl<Announcement> implements AnnouncementDAO {

    public AnnouncementDAOImpl() {
        setClazz(Announcement.class);
    }

    @Override
    public List<Announcement> getAnnouncementsByFilter(Filter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Announcement> criteriaQuery = cb.createQuery(Announcement.class);
        Root<Announcement> announcementRoot = criteriaQuery.from(Announcement.class);
        Join<Announcement, Subcategory> subcategoryJoin = announcementRoot.join(Announcement_.subcategory);
        Join<Subcategory, Category> categoryJoin = subcategoryJoin.join(Subcategory_.category);

        criteriaQuery.orderBy(cb.asc(announcementRoot.get(Announcement_.createDate)));
        criteriaQuery.select(announcementRoot);

        Predicate criteria = cb.conjunction();

        //active dates
        criteria = cb.and(criteria, cb.lessThan(announcementRoot.get(Announcement_.activeFrom), new Date()));
        criteria = cb.and(criteria, cb.greaterThan(announcementRoot.get(Announcement_.activeTo), new Date()));
        //City
        if(filter.getCity() != null)
            criteria = cb.and(criteria, cb.equal(announcementRoot.get(Announcement_.city), filter.getCity()));
        //Category
        if(filter.getCategory() != null)
            criteria = cb.and(criteria, cb.equal(categoryJoin.get(Category_.id), filter.getCategory().getId()));
        //Description words
        if(filter.getSearchWord() != null)
            criteria = cb.and(criteria, cb.like(announcementRoot.get(Announcement_.description), "%"+filter.getSearchWord()+"%"));

        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).setMaxResults(100).getResultList();
    }

    @Override
    public List<Announcement> getTopAnnouncements() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Announcement> criteriaQuery = cb.createQuery(Announcement.class);
        Root<Announcement> announcementRoot = criteriaQuery.from(Announcement.class);

        criteriaQuery.orderBy(cb.asc(announcementRoot.get(Announcement_.createDate)));
        criteriaQuery.select(announcementRoot);

        Predicate criteria = cb.conjunction();
        //active dates
        criteria = cb.and(criteria, cb.lessThan(announcementRoot.get(Announcement_.activeFrom), new Date()));
        criteria = cb.and(criteria, cb.greaterThan(announcementRoot.get(Announcement_.activeTo), new Date()));
        criteriaQuery.where(criteria);

        return entityManager.createQuery(criteriaQuery).setMaxResults(100).getResultList();
    }


}
