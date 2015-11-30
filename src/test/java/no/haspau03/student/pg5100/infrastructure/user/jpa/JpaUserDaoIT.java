package no.haspau03.student.pg5100.infrastructure.user.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Paul on 19.11.2015.
 */
public class JpaUserDaoIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private JPAUserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("Egentrening4");
        entityManager = factory.createEntityManager();
        userDAO = new JPAUserDAO(entityManager);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        factory.close();
    }

    @Test
    public void createUser() throws Exception {


    }
}
