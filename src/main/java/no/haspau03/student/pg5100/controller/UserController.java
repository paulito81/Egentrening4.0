package no.haspau03.student.pg5100.controller;

import no.haspau03.student.pg5100.infrastructure.user.jpa.JPAUser;
import no.haspau03.student.pg5100.infrastructure.user.UserDAO;
import no.haspau03.student.pg5100.model.Subject;
import no.haspau03.student.pg5100.model.User;
import no.haspau03.student.pg5100.model.WorkType;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Paul on 18.11.2015.
 */
@Model
public class UserController {

    @Inject @JPAUser
    private UserDAO userDAO;

    private int selectedId;
    private User user;

    @PostConstruct
    public void init(){
        user = new User();
    }
    public void persistNewUser(){
        userDAO.createUser(user);

    }
    public List<User> getAllUsers(){
       return userDAO.getAllUsers();
    }

    public void getUserByID(){

        user = userDAO.getUserByID(selectedId);
    }
    public int getSelectedId(){
        return selectedId;
    }
    public void setSelectedId(int selectedId){
        this.selectedId = selectedId;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user =user;
    }
    public List<SelectItem> getWorkTypes(){
        return Arrays.asList(WorkType.values()).stream().map(t-> new SelectItem(t, t.name())).collect(Collectors.toList());

    }

    public void deleteUser(){
        userDAO.deleteUser(selectedId);
    }

    public List<String> getSelectedSubjects() {
        return user.getSubjects().stream().map(Subject::getName).collect(Collectors.toList());
    }
    public List<SelectItem> getUsers(){
        List<User> users = userDAO.getAllUsers();
        return users.stream().map(u -> new SelectItem(u.getId(), u.getEmail())).collect(Collectors.toList());
    }

}

