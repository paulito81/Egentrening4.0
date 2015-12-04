package no.haspau03.student.pg5100.infrastructure.user;

import no.haspau03.student.pg5100.model.User;

import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public interface UserDAO {

    User createUser(User user);
    boolean updateAUser(User user);
    User getUserByID(int id);
    List<User> getAllUsers();
    boolean removeUser(int id);
}
