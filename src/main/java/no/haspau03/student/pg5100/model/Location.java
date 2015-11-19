package no.haspau03.student.pg5100.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Paul on 18.11.2015.
 */
@Entity
@NamedQuery(name = "Location.getAllUsers", query = "select l from Location l")
@SequenceGenerator(name = "SEQ_LOCATION", initialValue = 50)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCATION")
    private int id;

    @NotNull
    private String room;
    @NotNull
    private String building;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
