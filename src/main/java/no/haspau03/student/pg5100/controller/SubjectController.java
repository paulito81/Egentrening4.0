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
    private List<String> userIds;

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

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public void initSubject(){

        subject = subjectDAO.getSubjectById(subjectId);
    }

    public void deleteSubjectById(){
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
    public List<SelectItem> getLocations2(){
        List<Subject> subjects = getAllSubject();
        return subjects.stream().map(s -> new SelectItem(s.getId(), s.getName(), s.getLocation() + " -" + s.getName())).collect(Collectors.toList()) ;
    }

    public List<SelectItem> getLocations(){
        List<Location> locations = locationDAO.getAll();
        return locations.stream().map(l -> new SelectItem(l.getId(), l.getBuilding() + " -" + l.getRoom())).collect(Collectors.toList()) ;
    }
    public List<SelectItem> getUsers(){
        List<User> users = userDAO.getAllUsers();
        return users.stream().map(u -> new SelectItem(u.getId(), u.getEmail())).collect(Collectors.toList());
    }

    public void createNewSubject(){
        Location location = locationDAO.findByID(locationId);
        subject.setLocation(location);
        List<User> users = userIds.stream().map(id -> userDAO.getUserByID(Integer.parseInt(id))).collect(Collectors.toList());
        subject.setUsers(users);
        subjectDAO.createNewSubject(subject);
    }

    public void getSubjectById(){
        subject = subjectDAO.getSubjectById(subjectId);
    }



}
