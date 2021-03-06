package com.lesson7.homework7_1.security;

import com.lesson7.homework7_1.dao.UserDAO;
import com.lesson7.homework7_1.exception.BadRequestException;
import com.lesson7.homework7_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSession {

    private static User loggedUser = null;
    private UserDAO userDAO;

    private User user;

    @Autowired
    public UserSession(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser() {
        return user;
    }

    public void login(String userName, String password) throws BadRequestException {
        User user = userDAO.getUserByLoginAndPassword(userName, password);
        if(loggedUser != null)
            throw new BadRequestException("You are already logged as user: "+loggedUser.getUserName());
        if(user == null)
            throw  new BadRequestException("User with name: "+userName+" was not found, or password is incorrect");

        loggedUser = user;
    }

    public void logout() throws BadRequestException{
        if(loggedUser == null)
            throw new BadRequestException("No user is logged in.");
        loggedUser = null;
    }

    public void checkAuthorization() throws BadRequestException {
        if(loggedUser == null)
            throw new BadRequestException("You must be logged in system for perform this operation");
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

}
