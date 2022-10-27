package com.marjan.dao;

import com.marjan.helpers.JpaServices;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.*;

public interface Dao<T> {

    Optional<T> findById(Long id);

    T save(T t);

    List<T> all();

    Boolean update(Long id, T t);

    Boolean delete(Long id);

}
