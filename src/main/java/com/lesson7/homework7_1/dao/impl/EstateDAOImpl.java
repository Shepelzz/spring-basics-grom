package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.EstateDAO;
import com.lesson7.homework7_1.model.Estate;
import org.springframework.stereotype.Repository;

@Repository
public class EstateDAOImpl extends GeneralDAOImpl<Estate> implements EstateDAO {

    public EstateDAOImpl() {setClazz(Estate.class);}
}
