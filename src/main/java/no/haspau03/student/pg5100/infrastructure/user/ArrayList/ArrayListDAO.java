package no.haspau03.student.pg5100.infrastructure.user.ArrayList;

import no.haspau03.student.pg5100.infrastructure.user.UserDAO;
import no.haspau03.student.pg5100.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public class ArrayListDAO implements UserDAO {

    private UserDAO userDAO;
    List<User> userList = new ArrayList<>();

    public ArrayListDAO() {

    }

    @Override
    public User createUser(User user) {
        if(user!=null){
            userDAO.createUser(user);
            return user;
        }
        else
        return null;
    }

    @Override
    public boolean updateAUser(User user) {
        if(user!=null){
          userDAO.updateAUser(user);
           return true;
        }else
            return false;
    }

    @Override
    public User getUserByID(int id) {
        if(id !=0){
           return userDAO.getUserByID(id);
        }else
        throw new NullPointerException("Value is null!");
    }

    @Override
    public List<User> getAllUsers() {
        if(userList !=null) {
            return userDAO.getAllUsers();
        }else
            throw new NullPointerException("List is empty!");
    }

    @Override
    public boolean deleteUser(int id) {
        if(id !=0){
            return userDAO.deleteUser(id);
        }else
            throw new NullPointerException("User is not in the list!");
    }
}
