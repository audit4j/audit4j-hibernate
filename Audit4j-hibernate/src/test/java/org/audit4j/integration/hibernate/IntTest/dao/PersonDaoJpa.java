package org.audit4j.integration.hibernate.IntTest.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.audit4j.integration.hibernate.IntTest.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoJpa implements PersonDao {

    private EntityManager entityManager;

    public PersonDaoJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            result = entityManager.createQuery("SELECT p FROM Person p").getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return result;
    }

    @Override
    public void addPerson(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
