package com.lesson3.homework3_1.service;

import com.lesson3.homework3_1.exception.InternalServerError;
import com.lesson3.homework3_1.model.File;
import com.lesson3.homework3_1.model.Storage;

public interface Service {

    File put(Storage storage, File file) throws InternalServerError;
    File delete(Storage storage, File file) throws InternalServerError;
    void transferAll(Storage storageFrom, Storage storageTo) throws InternalServerError;
    void transferFile(Storage storageFrom, Storage storageTo, Long id) throws InternalServerError;

}
