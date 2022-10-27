package com.marjan.dao;

import com.marjan.entities.Categories;
import com.marjan.entities.Comments;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class CommentsDao implements Dao<Comments>{

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public CommentsDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    @Override
    public Optional<Comments> findById(Long id) {
        return Optional.ofNullable(em.find(Comments.class,id));
    }

    @Override
    public Comments save(Comments comment) {
        try {
            transaction.begin();
            if(comment == null){
                em.persist(null);
            }
            em.merge(comment);
            transaction.commit();
            return comment;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return comment;
    }

    @Override
    public List<Comments> all() {
        return em.createQuery("from Comments ", Comments.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Comments comments) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            transaction.begin();
            Optional<Comments> comment = findById(id);
            comment.ifPresent(c -> em.remove(c));
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
