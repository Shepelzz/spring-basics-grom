package com.lesson7.homework7_1.dao;

import com.lesson7.homework7_1.model.User;

public interface UserDAO extends GeneralDAO<User> {

    User getUserByLoginAndPassword(String userName, String password);

}
