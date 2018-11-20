package com.lesson3.homework3_1.dao;

import com.lesson3.homework3_1.exception.InternalServerError;
import com.lesson3.homework3_1.model.File;
import com.lesson3.homework3_1.model.Storage;

import java.util.List;

public interface FileDAO extends GeneralDAO<File>{

    File put(Storage storage, File file) throws InternalServerError;
    File delete(Storage storage, File file) throws InternalServerError;
    void transferFiles(Storage storageFrom, Storage storageTo, long filesSize) throws InternalServerError;
    void transferFile(Storage storageFrom, Storage storageTo, File file) throws InternalServerError;
    List<File> getFilesByStorageId(Long id) throws InternalServerError;

}
