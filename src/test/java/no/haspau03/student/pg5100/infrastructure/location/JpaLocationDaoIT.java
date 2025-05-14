package no.haspau03.student.pg5100.infrastructure.location;

import no.haspau03.student.pg5100.model.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JpaLocationDaoIT {

    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private JpaLocationDAO locationDAO;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("Egentrening4"); // NB: må matche persistence.xml
        entityManager = factory.createEntityManager();
        locationDAO = new JpaLocationDAO(entityManager);

        // Legg til testdata
        entityManager.getTransaction().begin();
        Location location = new Location("A101", "Main Building");
        entityManager.persist(location);
        entityManager.getTransaction().commit();
    }

    @After
    public void tearDown() throws Exception {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }

    @Test
    public void getAllDetachedLocations() {
        List<Location> locations = locationDAO.getAllDetachedLocations();
        assertEquals(1, locations.size()); // Forventer én "detached" location
    }
}