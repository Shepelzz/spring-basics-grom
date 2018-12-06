package com;

import com.lesson7.homework7_1.controller.*;
import com.lesson7.homework7_1.security.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@SpringBootApplication
public class Application {

    private static AnnouncementController sAnnouncementController;
    private AnnouncementController announcementController;
    private static CategoryController sCategoryController;
    private CategoryController categoryController;
    private static SubcategoryController sSubcategoryController;
    private SubcategoryController subcategoryController;
    private static UserController sUserController;
    private UserController userController;
    private static MainController sMainController;
    private MainController mainController;
    private static UserSession sUserSession;
    private UserSession userSession;

    private static EntityManager sEntityManager;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public Application(AnnouncementController announcementController, CategoryController categoryController, SubcategoryController subcategoryController, UserController userController, MainController mainController, UserSession userSession) {
        this.announcementController = announcementController;
        this.categoryController = categoryController;
        this.subcategoryController = subcategoryController;
        this.userController = userController;
        this.mainController = mainController;
        this.userSession = userSession;
    }

    @PostConstruct
    public void init(){
        Application.sAnnouncementController = announcementController;
        Application.sCategoryController = categoryController;
        Application.sSubcategoryController = subcategoryController;
        Application.sUserController = userController;
        Application.sEntityManager = entityManager;
        Application.sMainController = mainController;
        Application.sUserSession = userSession;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

//        Filter filter = new Filter();
//        filter.setSearchWord("pool");
//        filter.setCategory(sCategoryController.findById(1L));
//
//        for(Announcement an : sMainController.getTopAnnouncements()){
//            System.out.println(an.toString());
//        }

//        sMainController.login("testuser", "1111");
//
//        Announcement a = new Announcement();
//        a.setTitle("test");
//        a.setDescription("testdescr");
//        a.setUser(UserSession.getLoggedUser());
//        a.setSubcategory(sSubcategoryController.findById(2L));
//        a.setPrice(567);
//        a.setCurrency("USD");
//        a.setPhone("78787");
//        a.setCity("London");
//        a.setCreateDate(new Date());
//        a.setActiveFrom(new Date());
//        a.setActiveTo(makeDate("2019-01-01"));
//
//        System.out.println(sAnnouncementController.save(a));

    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}