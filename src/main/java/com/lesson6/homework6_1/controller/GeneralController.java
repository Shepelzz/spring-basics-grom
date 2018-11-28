package com.lesson6.homework6_1.controller;

import com.lesson6.homework6_1.model.GeneralModel;

import java.util.Collection;

abstract class GeneralController<T extends GeneralModel> {

    String parseObjectList(Collection<T> list){
        StringBuilder sb = new StringBuilder();
        for(T t : list)
            sb.append(t.toString()).append("\n");
        return sb.toString();
    }
}
