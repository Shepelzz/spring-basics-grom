package com.lesson3.homework3_1.dao;

import com.lesson3.homework3_1.exception.InternalServerError;
import com.lesson3.homework3_1.model.File;
import com.lesson3.homework3_1.model.Storage;
import org.hibernate.Session;

public interface StorageDAO extends GeneralDAO<Storage>{
    enum sizeActions {INCREASE, DECREASE}

    void changeSize(Long id, Long size, Session session, sizeActions act) throws InternalServerError;
    int checkStorageOnExistingFiles(File file) throws InternalServerError;
    int checkStorageOnExistingFiles(Storage storageFrom, Storage storageTo) throws InternalServerError;

}
