package infrastructure.user.JPA;

import infrastructure.user.UserDAO;
import model.User;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public class JPAUserDAO implements UserDAO {

    @PersistenceContext(unitName = "user")
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    JPAUserDAO() {

    }

    public void JPAUserDAO(EntityManagerFactory entityManagerFactory) throws ClassNotFoundException, SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("user");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public User createANewUser(User user) {
        if (user != null) {
            entityManager.persist(user);
            return user;
        }
        throw new NullPointerException("User wher not found @Nullpointer");
    }

    private void close(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public boolean updateAUser(User user) {
        if(user !=null){
            entityManager.persist(user);
            return true;
        }
        else
            throw new NullPointerException("User where not found @Nullpointer");
    }

    @Override
    public User getUserByID(int id) {
        if(id !=0){
            entityManager.find(User.class, id);
        }
        throw new NullPointerException("User with id-nr:["+id+ "] where not found");
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.getAllUsers", User.class);
        return query.getResultList();
    }

    @Override
    public boolean deleteUser(int id) {
        Query query = entityManager.createNamedQuery("User.deleteUser");
        query.setParameter("id", id);
        int rows = query.executeUpdate();
        return rows == 1;
    }
}
