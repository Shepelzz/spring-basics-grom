package com.lesson5.homework5_1;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Item save(Item item){
        entityManager.persist(item);
        return item;
    }

    public Item update(Item item){
        entityManager.merge(item);
        return item;
    }

    public void delete(Long id){
        entityManager.remove(entityManager.find(Item.class, id));
    }

}
