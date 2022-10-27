package com.marjan.dao;

import com.marjan.entities.Cities;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CitiesDao implements Dao<Cities>{

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public CitiesDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }
    @Override
    public Optional<Cities> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cities save(Cities city) {
        try {
            transaction.begin();
            if(city == null){
                em.persist(null);
            }
            em.merge(city);
            transaction.commit();
            return city;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return city;
    }

    @Override
    public List<Cities> all() {
        return null;
    }

    @Override
    public Boolean update(Long id, Cities cities) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
