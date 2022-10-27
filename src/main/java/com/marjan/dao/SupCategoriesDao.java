package com.marjan.dao;

import com.marjan.entities.SupCategories;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class SupCategoriesDao implements Dao<SupCategories>{

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public SupCategoriesDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    @Override
    public Optional<SupCategories> findById(Long id) {
        return Optional.ofNullable(em.find(SupCategories.class,id));
    }

    @Override
    public SupCategories save(SupCategories supCategory) {
        try {
            transaction.begin();
            if(supCategory == null){
                em.persist(null);
            }
            em.merge(supCategory);
            transaction.commit();
            return supCategory;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return supCategory;
    }

    @Override
    public List<SupCategories> all() {
        return null;
    }

    @Override
    public Boolean update(Long id, SupCategories supCategories) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            transaction.begin();
            Optional<SupCategories> supCategory = findById(id);
            supCategory.ifPresent(s -> em.remove(s));
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
