package com.lesson7.homework7_1.dao.impl;

import com.lesson7.homework7_1.dao.SubcategoryDAO;
import com.lesson7.homework7_1.model.Category;
import com.lesson7.homework7_1.model.Category_;
import com.lesson7.homework7_1.model.Subcategory;
import com.lesson7.homework7_1.model.Subcategory_;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class SubcategoryDAOImpl extends GeneralDAOImpl<Subcategory> implements SubcategoryDAO {

    private static final String SQL_GET_ALL_SUBCATEGORIES = "SELECT * FROM SUBCATEGORY";

    public SubcategoryDAOImpl() {
        setClazz(Subcategory.class);
    }

    @Override
    public List<Subcategory> getAll(){
        return (List<Subcategory>) entityManager.createNativeQuery(SQL_GET_ALL_SUBCATEGORIES, Subcategory.class).getResultList();
    }

    @Override
    public List<Subcategory> getAllByCategory(Category category){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subcategory> criteriaQuery = cb.createQuery(Subcategory.class);
        Root<Subcategory> subcategoryRoot = criteriaQuery.from(Subcategory.class);
        Join<Subcategory, Category> categoryJoin = subcategoryRoot.join(Subcategory_.category);

        criteriaQuery.select(subcategoryRoot);
        Predicate criteria = cb.conjunction();
        //Category
        if(category != null)
            criteria = cb.and(criteria, cb.equal(categoryJoin.get(Category_.id), category.getId()));

        criteriaQuery.where(criteria);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
