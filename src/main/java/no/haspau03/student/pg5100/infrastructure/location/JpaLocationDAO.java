package no.haspau03.student.pg5100.infrastructure.location;

import no.haspau03.student.pg5100.model.Location;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
@Stateless
public class JpaLocationDAO implements LocationDAO {

    @PersistenceContext(unitName = "Egentrening4")
    private EntityManager entityManager;

    public JpaLocationDAO(){
    }

    JpaLocationDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Location persist(Location location) {
        if(location !=null){
            entityManager.persist(location);
            return location;
        }
        throw new IllegalArgumentException("No value found- null! :(");
    }

    @Override
    public Location findByID(int id) {
        if (id !=0) {
            return entityManager.find(Location.class, id);
        }
        throw new IllegalArgumentException("No value found :(");
    }

    @Override
    public List<Location> getAll() {
        TypedQuery<Location> query = entityManager.createNamedQuery("Location.getAllUsers", Location.class);
        return query.getResultList();
    }

    @Override
    public boolean removeLocation(int id) {
        if(id != 0) {
            entityManager.remove(id);
            return true;
        }
        throw new IllegalArgumentException("Value is not found :(");
    }


}
