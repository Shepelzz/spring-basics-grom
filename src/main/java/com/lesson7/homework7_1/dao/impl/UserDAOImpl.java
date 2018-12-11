package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class UserDAOImpl extends GeneralDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        setClazz(User.class);
    }

    @Override
    public User getUserByLoginAndPassword(String userName, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);
        Predicate criteria = cb.conjunction();
        //Login
        criteria = cb.and(criteria, cb.equal(userRoot.get("userName"), userName));
        criteria = cb.and(criteria, cb.equal(userRoot.get("password"), password));

        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
