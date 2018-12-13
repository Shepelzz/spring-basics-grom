package com.lesson7.homework7_1.security;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionList {

    private static Map<User, UserSession> userUserSessionHashMap = new HashMap<User,UserSession>();
    private static UserSession currentSession;

    private UserDAO userDAO;

    @Autowired
    public SessionList(UserDAO userDAO) {
        this.userDAO = userDAO;
    }




}
