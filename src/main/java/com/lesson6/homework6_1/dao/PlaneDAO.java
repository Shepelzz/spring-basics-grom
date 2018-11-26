package com.lesson6.homework6_1.dao;

import com.lesson6.homework6_1.model.Plane;

import java.util.Collection;

public interface PlaneDAO extends GeneralDAO<Plane>{
    Collection<Plane> oldPlanes();
    Collection<Plane> regularPlanes();

}
