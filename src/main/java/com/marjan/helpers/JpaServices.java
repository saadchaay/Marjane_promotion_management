package com.marjan.helpers;

import jakarta.persistence.*;

public class JpaServices {

    private static JpaServices instance;

    private final EntityManagerFactory entityManagerFactory;

    private JpaServices(){
        entityManagerFactory = Persistence.createEntityManagerFactory("promotion-marjan");
    }

    public static synchronized JpaServices getInstance(){
        return instance == null ? instance = new JpaServices() : instance ;
    }

    public void shutdown(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
            instance = null;
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
