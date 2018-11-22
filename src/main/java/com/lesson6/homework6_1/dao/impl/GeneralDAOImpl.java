package com.lesson6.homework6_1.dao.impl;

import com.lesson6.homework6_1.dao.GeneralDAO;
import com.lesson6.homework6_1.model.Model;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GeneralDAOImpl<T extends Model> implements GeneralDAO<T> {

    private Class<T> clazz;

    public final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
    }

//    public T findById(Long id) throws InternalServerError{
//        try (Session session = createSessionFactory().openSession()) {
//
//            return session.get(clazz, id);
//
//        } catch (HibernateException e) {
//            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
//        } catch (NoResultException noe){
//            throw new BadRequestException("There is not "+clazz.getName()+" entity with id: "+id+". "+noe.getMessage());
//        }
//    }

}
