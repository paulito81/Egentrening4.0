package model;


import model.constraint.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
@Entity
@NamedQueries(value =  {
        @NamedQuery(name = "User.getAllUsers", query = "select u from User u"),
        @NamedQuery(name = "User.deleteUser", query = "delete from User u where u.id = :id"),
})
@SequenceGenerator(name ="User.sequence", sequenceName = "SEQ_USER", initialValue = 50)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    private int id;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    private String email;
    @NotNull
    @ValidPassword
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @ManyToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Subject> subjects;

    public User() {

    }

    public User(int id, String email, String password, WorkType workType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.workType = workType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
