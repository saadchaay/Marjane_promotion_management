package com.marjan.dao;

import com.marjan.entities.Promotions;
import com.marjan.helpers.JpaServices;
import jakarta.persistence.*;

import java.util.*;

public class PromotionsDao implements Dao<Promotions>{

    JpaServices jpaService = JpaServices.getInstance();
    EntityManagerFactory entityManagerFactory;
    EntityManager em;
    EntityTransaction transaction;

    public PromotionsDao(){
        entityManagerFactory = jpaService.getEntityManagerFactory();
        em = entityManagerFactory.createEntityManager();
        transaction = em.getTransaction();
    }

    @Override
    public Optional<Promotions> findById(Long id) {
        return Optional.ofNullable(em.find(Promotions.class, id));
    }

    @Override
    public Promotions save(Promotions promo) {
        try {
            transaction.begin();
            if(promo == null){
                em.persist(null);
            }
            em.merge(promo);
            transaction.commit();
            return promo;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return promo;
    }

    @Override
    public List<Promotions> all() {
        return em.createQuery("from Promotions ", Promotions.class).getResultList();
    }

    @Override
    public Boolean update(Long id, Promotions promo) {
        try {
            transaction.begin();
            String hql = "UPDATE Promotions set status = :status " + "WHERE id = :promoId";
            Query qry = em.createQuery(hql);
            qry.setParameter("status", promo.getStatus());
            qry.setParameter("promoId", id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            jpaService.shutdown();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try{
            transaction.begin();
            Optional<Promotions> promo = findById(id);
            promo.ifPresent(pro -> em.remove(pro));
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
