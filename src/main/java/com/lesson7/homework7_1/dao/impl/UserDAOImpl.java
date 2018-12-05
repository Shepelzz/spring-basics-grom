package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GeneralDAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        setClazz(User.class);
    }
}
