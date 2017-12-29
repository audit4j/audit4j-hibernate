package org.audit4j.integration.hibernate.IntTest;

import org.audit4j.integration.hibernate.IntTest.dao.PersonDaoJpa;
import org.audit4j.integration.hibernate.IntTest.model.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.audit4j.integration.hibernate.IntTest.model.PersonBuilder.aPerson;

public class PersonDaoJpaIntegrationTest {

    private PersonDaoJpa personDaoJpa;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        personDaoJpa = new PersonDaoJpa(entityManager);
    }

    @After
    public void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void shouldFindPreviouslySavedPerson() {
        
       
        
        // given
        Integer age = 22;
        String name = "Charlie";
        Person person = aPerson().
                withAge(age).
                withName(name).build();

        personDaoJpa.addPerson(person);

        // when
        List<Person> result = personDaoJpa.findAll();

        // then
        assertThat(result, hasSize(1));
        Person foundPerson = result.get(0);
        assertThat(foundPerson.getAge(), is(age));
        assertThat(foundPerson.getName(), is(name));
    }
}
