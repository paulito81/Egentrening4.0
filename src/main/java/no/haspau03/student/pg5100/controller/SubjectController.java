package no.haspau03.student.pg5100.controller;

import no.haspau03.student.pg5100.infrastructure.location.LocationDAO;
import no.haspau03.student.pg5100.infrastructure.subject.SubjectDAO;
import no.haspau03.student.pg5100.infrastructure.user.UserDAO;
import no.haspau03.student.pg5100.infrastructure.user.jpa.JPAUser;
import no.haspau03.student.pg5100.model.Location;
import no.haspau03.student.pg5100.model.Subject;
import no.haspau03.student.pg5100.model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Paul on 19.11.2015.
 */
@Model
public class SubjectController {

    @Inject
    SubjectDAO subjectDAO;

    @Inject
    LocationDAO locationDAO;

    @Inject @JPAUser
    private UserDAO userDAO;

    private int subjectId;
    private Subject subject;

    private int locationId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;


    @PostConstruct
    public void init(){
        subject = new Subject();
    }


    public List<Subject> getAllSubject(){

        return subjectDAO.getAllUsersBySubject() ;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }


    public void initSubject(){

        subject = subjectDAO.getSubjectById(subjectId);
    }

    public void deleteSubjectById(int subjectId){

        subjectDAO.removeSubject(subjectId);
    }

    public String getSelectedLocation(){
        Location location = subject.getLocation();
        return location.getBuilding() + " - " + location.getRoom() ;
    }

    public List<String> getSelectedUsers() {
        List<User> users = subject.getUsers();
        return users.stream().map(User::getEmail).collect(Collectors.toList());
    }
    public List<SelectItem> getSubjects(){
        List<Subject> subjects = getAllSubject();
        return subjects.stream().map(s -> new SelectItem(s.getId(), s.getName(), s.getLocation() + " -" + s.getName())).collect(Collectors.toList()) ;
    }

    public List<SelectItem> getLocations(){
        List<Location> locations = locationDAO.getAllLocations();
        return locations.stream().map(l -> new SelectItem(l.getId(), l.getBuilding() + " -" + l.getRoom())).collect(Collectors.toList()) ;
    }
    public List<SelectItem> getUsers(){
        List<User> users = userDAO.getAllUsers();
        return users.stream().map(u -> new SelectItem(u.getId(), u.getEmail())).collect(Collectors.toList());
    }

    public void createNewSubject( ){
        Location location = locationDAO.findByID(locationId);
        User user = userDAO.getUserByID(userId);
        List<User> users = new ArrayList<>();
        subject.setUsers(users);
        users.add(user);
        subject.setLocation(location);
        subject.setId(userId);
        subjectDAO.createSubject(subject);
    }


    public void getSubjectById(){
        subject = subjectDAO.getSubjectById(subjectId);
    }


}
