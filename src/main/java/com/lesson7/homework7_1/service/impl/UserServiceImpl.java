package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import com.lesson7.homework7_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }
}
