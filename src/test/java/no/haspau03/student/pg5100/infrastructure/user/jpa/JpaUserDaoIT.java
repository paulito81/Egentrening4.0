package no.haspau03.student.pg5100.infrastructure.user.jpa;

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
    private JpaUserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("Egentrening4");
        entityManager = factory.createEntityManager();
        userDAO = new JpaUserDAO(entityManager);
    }

    @Test
    public void createUser() throws Exception {


    }
}
