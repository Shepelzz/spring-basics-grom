package com;

import com.lesson7.homework7_1.controller.AnnouncementController;
import com.lesson7.homework7_1.controller.EstateController;
import com.lesson7.homework7_1.controller.MainController;
import com.lesson7.homework7_1.controller.UserController;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.model.Subcategory;
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
    private static UserController sUserController;
    private UserController userController;
    private static MainController sMainController;
    private MainController mainController;
    private static UserSession sUserSession;
    private UserSession userSession;
    private static EstateController sEstateController;
    private EstateController estateController;

    private static EntityManager sEntityManager;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public Application(AnnouncementController announcementController, UserController userController, MainController mainController, UserSession userSession, EstateController estateController) {
        this.announcementController = announcementController;
        this.userController = userController;
        this.mainController = mainController;
        this.userSession = userSession;
        this.estateController = estateController;
    }

    @PostConstruct
    public void init(){
        Application.sAnnouncementController = announcementController;
        Application.sUserController = userController;
        Application.sEntityManager = entityManager;
        Application.sMainController = mainController;
        Application.sUserSession = userSession;
        Application.sEstateController = estateController;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

//        Filter filter = new Filter();
//        filter.setSearchWord("pool");
////        filter.setCategory(sCategoryController.findById(1L));
////
//        for(Announcement an : sAnnouncementController.getAnnouncementsByFilter(filter)){
//            System.out.println(an.toString());
//        }

//        sMainController.login("testuser", "1111");
//
        sUserSession.login("adm", "1111");


        Announcement a = new Announcement();
        a.setTitle("test");
        a.setDescription("testdescr");
        a.setUser(UserSession.getLoggedUser());
        a.setEstate(sEstateController.findById(1L));
        a.setCategory(Category.CATEGORY_1);
        a.setSubcategory(Subcategory.SUBCATEGORY_2);
        a.setPrice(567);
        a.setCurrency("USD");
        a.setPhone("78787");
        a.setCity("London");
        a.setCreateDate(new Date());
        a.setActiveFrom(new Date());
        a.setActiveTo(makeDate("2019-01-01"));

        System.out.println(sAnnouncementController.save(a));


    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}