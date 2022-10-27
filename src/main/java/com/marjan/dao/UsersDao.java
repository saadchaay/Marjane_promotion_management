package com.marjan.dao;

import com.marjan.entities.Users;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.*;

public class UsersDao implements Dao<Users> {

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public UsersDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return Optional.ofNullable(em.find(Users.class, id));
    }

    @Override
    public Users save(Users user) {
        try {
            transaction.begin();
            if(user == null){
                em.persist(null);
            }
            em.merge(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return null;
    }

    @Override
    public List<Users> all() {
        return em.createQuery("from Users ", Users.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Users users) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            transaction.begin();
            Optional<Users> user = findById(id);
            user.ifPresent(us -> em.remove(us));
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
