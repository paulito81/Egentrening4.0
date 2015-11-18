package infrastructure.user;

import model.User;

import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public interface UserDAO {

    User createANewUser(User user);
    boolean updateAUser(User user);
    User getUserByID(int id);
    List<User> getAllUsers();
    boolean deleteUser(int id);
}
