package com.lesson6.homework6_1.service.impl;

import com.lesson6.homework6_1.dao.PlaneDAO;
import com.lesson6.homework6_1.exception.BadRequestException;
import com.lesson6.homework6_1.model.Plane;
import com.lesson6.homework6_1.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceImpl implements PlaneService {

    private PlaneDAO planeDAO;

    @Autowired
    public PlaneServiceImpl(PlaneDAO planeDAO) {
        this.planeDAO = planeDAO;
    }

    @Override
    public Plane save(Plane plane) throws BadRequestException{
        planeValidator(plane);
        return planeDAO.save(plane);
    }

    @Override
    public Plane update(Plane plane) throws BadRequestException{
        planeValidator(plane);
        return planeDAO.update(plane);
    }

    private void planeValidator(Plane plane) throws BadRequestException{
        if(plane.getModel().equals(""))
            throw new BadRequestException("Plane model can not be empty");
        if(plane.getCode().equals(""))
            throw new BadRequestException("Plane code can not be empty");
    }
}
