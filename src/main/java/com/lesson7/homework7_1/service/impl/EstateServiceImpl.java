package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.EstateDAO;
import com.lesson7.homework7_1.model.Estate;
import com.lesson7.homework7_1.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EstateServiceImpl implements EstateService {
    private EstateDAO estateDAO;

    @Autowired
    public EstateServiceImpl(EstateDAO estateDAO) {
        this.estateDAO = estateDAO;
    }

    @Transactional
    @Override
    public Estate save(Estate estate) {
        return estateDAO.save(estate);
    }

    @Transactional
    @Override
    public Estate update(Estate estate) {
        return estateDAO.update(estate);
    }
}
