package no.haspau03.student.pg5100.infrastructure.location;

import junit.framework.Assert;
import no.haspau03.student.pg5100.model.Location;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Paul on 19.11.2015.
 */
public class JpaLocationDaoIT {
    private EntityManagerFactory factory;
    private EntityManager entityManager;
    private JpaLocationDAO locationDAO;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("Egentrening 4.0");
        entityManager = factory.createEntityManager();
         locationDAO = new JpaLocationDAO(entityManager);
    }

    @Test
    public void getAllDetachedLocations() {

        List<Location> locations = locationDAO.getAllDetachedLocations();

        Assert.assertEquals(1, locations.size());
    }
}
