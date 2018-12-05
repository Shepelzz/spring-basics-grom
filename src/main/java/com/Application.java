package com;

import com.lesson7.homework7_1.controller.AnnouncementController;
import com.lesson7.homework7_1.controller.CategoryController;
import com.lesson7.homework7_1.controller.SubcategoryController;
import com.lesson7.homework7_1.controller.UserController;
import com.lesson7.homework7_1.model.Announcement;
import com.lesson7.homework7_1.model.Filter;
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

    private static EntityManager sEntityManager;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public Application(AnnouncementController announcementController, CategoryController categoryController, SubcategoryController subcategoryController, UserController userController) {
        this.announcementController = announcementController;
        this.categoryController = categoryController;
        this.subcategoryController = subcategoryController;
        this.userController = userController;
    }

    @PostConstruct
    public void init(){
        Application.sAnnouncementController = announcementController;
        Application.sCategoryController = categoryController;
        Application.sSubcategoryController = subcategoryController;
        Application.sUserController = userController;
        Application.sEntityManager = entityManager;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        Filter filter = new Filter();
        filter.setSearchWord("pool");
        filter.setCategory(sCategoryController.findById(1L));

        for(Announcement an : sAnnouncementController.getTopAnnouncements(filter)){
            System.out.println(an.toString());
        }


    }

    public static Date makeDate(String dt) throws ParseException {
        return new SimpleDateFormat("yyyy-mm-dd").parse(dt);
    }

}