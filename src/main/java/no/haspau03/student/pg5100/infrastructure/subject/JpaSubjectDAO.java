package no.haspau03.student.pg5100.infrastructure.subject;

import no.haspau03.student.pg5100.model.Location;
import no.haspau03.student.pg5100.model.Subject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */

@Stateless
public class JpaSubjectDAO implements SubjectDAO{


    @PersistenceContext(unitName = "Egentrening4")
    private EntityManager entityManager;

    public JpaSubjectDAO( ) {
    }

    JpaSubjectDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Subject createSubject(Subject subject) {
        if(subject == null)
            throw new IllegalArgumentException("Subject not found :(");

        entityManager.persist(subject);
        return subject;
    }

    @Override
    public Subject getSubjectById(int id) {
        if(id !=0){
            return entityManager.find(Subject.class, id);
        }
        else
            throw new IllegalArgumentException("No value where found");
    }

    @Override
    public List<Subject> getAllUsersBySubject() {
        TypedQuery<Subject> query = entityManager.createNamedQuery("Subject.getUsers", Subject.class);
        return query.getResultList();
    }

    @Override
    public boolean removeSubject(int id) {
        if(id != 0) {
            entityManager.remove(id);
            return true;
        }
        throw new IllegalArgumentException("Value is not found :(");
    }

    @Override
    public List<Subject> getAllDetachedSubjects() {
        List<Subject> detachedSubjects = new ArrayList<>();
        List<Subject> subjects = getAllUsersBySubject();
        for(Subject subject : subjects){
            TypedQuery<Location> query = entityManager.createNamedQuery("Location.getLocationForSubject", Location.class);
            query.setParameter("id", subject.getId());
            List<Location> locations = query.getResultList();
            if( locations.isEmpty()){
                detachedSubjects.add(subject);
            }
        }
        return detachedSubjects;
    }
}
