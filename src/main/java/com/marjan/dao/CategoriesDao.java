package com.marjan.dao;

import com.marjan.entities.Categories;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CategoriesDao implements Dao<Categories>{

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public CategoriesDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return Optional.ofNullable(em.find(Categories.class,id));
    }

    @Override
    public Categories save(Categories category) {
        try {
            transaction.begin();
            if(category == null){
                em.persist(null);
            }
            em.merge(category);
            transaction.commit();
            return category;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return category;
    }

    @Override
    public List<Categories> all() {
        return null;
    }

    @Override
    public Boolean update(Long id, Categories categories) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            transaction.begin();
            Optional<Categories> category = findById(id);
            category.ifPresent(c -> em.remove(c));
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            return false;
        } finally {
            jpaService.shutdown();
        }
        return true;
    }
}
