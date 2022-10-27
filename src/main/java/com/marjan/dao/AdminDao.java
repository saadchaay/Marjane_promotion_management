package com.marjan.dao;

import com.marjan.entities.SupAdmin;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class AdminDao implements Dao<SupAdmin> {

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public AdminDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }
    @Override
    public Optional<SupAdmin> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public SupAdmin save(SupAdmin supAdmin) {
        try {
            transaction.begin();
            if(supAdmin == null){
                em.persist(null);
            }
            em.merge(supAdmin);
            transaction.commit();
            return supAdmin;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return supAdmin;
    }

    @Override
    public List<SupAdmin> all() {
        return em.createQuery("from SupAdmin ", SupAdmin.class).getResultList();
    }

    @Override
    public Boolean update(Long id, SupAdmin supAdmin) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
