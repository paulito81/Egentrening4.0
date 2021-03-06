package no.haspau03.student.pg5100.infrastructure.user.jpa;

import no.haspau03.student.pg5100.infrastructure.user.UserDAO;
import no.haspau03.student.pg5100.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
@JPAUser
@Stateless
public class JPAUserDAO implements UserDAO {

    @PersistenceContext(unitName = "Egentrening4")
    private EntityManager entityManager;

    public JPAUserDAO() {
    }

    JPAUserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User createUser(User user) {
        if (user == null)
            throw new IllegalArgumentException("User coul not be created, we got a nullpointer!  =(" );

        entityManager.persist(user);
        return user;
    }

    @Override
    public boolean updateAUser(User user) {
        if (user == null)
            throw new IllegalArgumentException("User is not found, we got a nullpointer!  =(" );

        if (entityManager.contains(user)) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }

        return true;
    }

    @Override
    public User getUserByID(int id) {
        if (id == 0)
            throw new IllegalArgumentException(String.format("User with id-nr:[%d] where not found  =( ", id));

        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.getAllUsers", User.class);
        return query.getResultList();
    }

    @Override
    public boolean removeUser(int id) {
        if (id != 0) {
            User user = entityManager.find(User.class, id);
            entityManager.remove(user);
            return true;
        }
        throw new IllegalArgumentException(String.format("User with id-nr:[%d] where not found =(", id));
    }
}