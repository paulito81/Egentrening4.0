package model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
@Entity
@NamedQuery(name = "Subject.getUsers", query = "select s from Subject s")
@SequenceGenerator(name = "SEQ_SUBJECT", initialValue = 50)
public class Subject {

    public Subject(String name, List<User> users, Location location) {
        this.name = name;
        this.users = users;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SUBJECT")
    private int id;

    @NotNull
    private String name;

    @NotNull
    @Size(min = 0, max = 100)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USR_SUB")
    private List<User> users;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "FK_LOCATION")
    @Valid
    private Location location;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
