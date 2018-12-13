package com.lesson7.homework7_1.service.impl;

import com.lesson7.homework7_1.dao.EstateDAO;
import com.lesson7.homework7_1.exception.BadRequestException;
import com.lesson7.homework7_1.model.Estate;
import com.lesson7.homework7_1.security.UserSession;
import com.lesson7.homework7_1.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EstateServiceImpl implements EstateService {
    private EstateDAO estateDAO;
    private UserSession userSession;

    @Autowired
    public EstateServiceImpl(EstateDAO estateDAO, UserSession userSession) {
        this.estateDAO = estateDAO;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public Estate save(Estate estate) throws BadRequestException {
        userSession.checkAuthorization();
        return estateDAO.save(estate);
    }

    @Transactional
    @Override
    public Estate update(Estate estate) throws BadRequestException {
        userSession.checkAuthorization();
        return estateDAO.update(estate);
    }
}
