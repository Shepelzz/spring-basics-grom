package com.lesson2.homework2_2.dao;

import com.lesson2.homework2_2.exception.BadRequestException;
import com.lesson2.homework2_2.exception.InternalServerError;
import com.lesson2.homework2_2.model.L2hw2_Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class L2hw2_ItemDAO {
    private SessionFactory sessionFactory;

    private static final String SQL_FIND_ITEM_BY_NAME = "SELECT * FROM ITEM WHERE NAME = :name";

    public L2hw2_Item save(L2hw2_Item item) throws InternalServerError {
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.save(item);

            session.getTransaction().commit();
            return item;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Save "+item.getClass().getSimpleName()+": "+item.toString()+" failed"+e.getMessage());
        }
    }

    public L2hw2_Item update(L2hw2_Item item) throws InternalServerError{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.update(item);

            session.getTransaction().commit();
            return item;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Update "+item.getClass().getSimpleName()+": "+item.toString()+" failed"+e.getMessage());
        }
    }

    public L2hw2_Item delete(L2hw2_Item item) throws InternalServerError{
        Transaction transaction = null;
        try (Session session = createSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();

            session.delete(item);

            session.getTransaction().commit();
            return item;
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            throw new InternalServerError("Delete "+item.getClass().getSimpleName()+": "+item.toString()+" failed"+e.getMessage());
        }
    }

    public L2hw2_Item findById(Long id) throws InternalServerError, BadRequestException {
        try (Session session = createSessionFactory().openSession()) {
            return session.get(L2hw2_Item.class, id);
        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findById: "+id+" failed. "+e.getMessage());
        } catch (NoResultException noe){
            throw new BadRequestException("There is not Item with id: "+id+". "+noe.getMessage());
        }
    }

    public L2hw2_Item findByName(String name) throws InternalServerError{
        try (Session session = createSessionFactory().openSession()) {
            return (L2hw2_Item) session.createSQLQuery(SQL_FIND_ITEM_BY_NAME)
                    .setParameter("name", name)
                    .addEntity(L2hw2_Item.class).getSingleResult();
        } catch (HibernateException e) {
            throw new InternalServerError(getClass().getSimpleName()+"-findByName: "+name+" failed. "+e.getMessage());
        } catch (NoResultException e){
            return null;
        }
    }


    private SessionFactory createSessionFactory(){
        if(sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
