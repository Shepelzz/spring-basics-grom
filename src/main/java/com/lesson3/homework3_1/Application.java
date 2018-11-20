package com.lesson3.homework3_1;

import com.lesson3.homework3_1.controller.Controller;
import com.lesson3.homework3_1.dao.FileDAO;
import com.lesson3.homework3_1.dao.StorageDAO;
import com.lesson3.homework3_1.model.File;
import com.lesson3.homework3_1.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@SpringBootApplication
public class Application {

    private static Controller sController;
    private Controller controller;

    private static StorageDAO sStorageDAO;
    private StorageDAO storageDAO;
    private static FileDAO sFileDAO;
    private FileDAO fileDAO;

    @Autowired
    public Application(Controller controller, StorageDAO storageDAO, FileDAO fileDAO) {
        this.controller = controller;
        this.storageDAO = storageDAO;
        this.fileDAO = fileDAO;
    }

    @PostConstruct
    public void init(){
        Application.sController = controller;
        Application.sStorageDAO = storageDAO;
        Application.sFileDAO = fileDAO;
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        File file = new File();
        file.setName("10Rrrrrrrr");
        file.setFormat("txt");
        file.setSize(1);

//        File exFile = new File();
//        exFile.setName("7");
//        exFile.setFormat("txt");
//        exFile.setSize(2);

        Storage storage1 = sStorageDAO.findById(1L); //944
        Storage storage2 = sStorageDAO.findById(2L); //754
        File f85 = sFileDAO.findById(85L);
        File fd = sFileDAO.findById(72L);

        sController.put(storage1, file);
//        sController.delete(storage2, fd);
//        sController.transferFile(storage1, storage2, 86L);
//        sController.transferAll(storage2, storage1);


//        System.out.println(controller.put(storage, file));
    }
}