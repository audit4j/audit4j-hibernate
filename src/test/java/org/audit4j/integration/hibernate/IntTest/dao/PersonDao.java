package org.audit4j.integration.hibernate.IntTest.dao;


import java.util.List;

import org.audit4j.integration.hibernate.IntTest.model.Person;

public interface PersonDao {

    List<Person> findAll();

    void addPerson(Person person);
}
