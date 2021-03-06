package com.lesson3.homework3_1.dao;

import com.lesson3.homework3_1.exception.BadRequestException;
import com.lesson3.homework3_1.exception.InternalServerError;
import com.lesson3.homework3_1.model.Model;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public abstract class GeneralDAOImpl<T extends Model> implements GeneralDAO<T>{

    private Class<T> clazz;
    private SessionFactory sessionFactory;

    public final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findById(Long id) throws InternalServerError{
        try (Session session = createSessionFactory().openSession()) {

            return session.get(clazz, id);

        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
        } catch (NoResultException noe){
            throw new BadRequestException("There is not "+clazz.getName()+" entity with id: "+id+". "+noe.getMessage());
        }
    }



    public SessionFactory createSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
