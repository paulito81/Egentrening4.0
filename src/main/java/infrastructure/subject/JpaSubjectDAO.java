package infrastructure.subject;

import model.Subject;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
@Stateless
public class JpaSubjectDAO implements SubjectDAO{


    @PersistenceContext(unitName = "Egentrening 4.0")
    private EntityManager entityManager;

    public JpaSubjectDAO( ) {
    }

    JpaSubjectDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Subject createNewSubject(Subject subject) {
        if(subject !=null){
            entityManager.persist(subject);
            return subject;
        }
        else
            throw new NullPointerException("No value was found");
    }

    @Override
    public Subject getSubjectById(int id) {
        if(id !=0){
            return entityManager.find(Subject.class, id);
        }
        else
            throw new NullPointerException("No value where found");
    }

    @Override
    public List<Subject> getAllUsersBySubject() {
        TypedQuery<Subject> query = entityManager.createNamedQuery("Subject.getUsers", Subject.class);
        return query.getResultList();
    }
}
