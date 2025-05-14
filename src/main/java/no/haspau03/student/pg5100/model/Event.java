package no.haspau03.student.pg5100.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Paul on 03.12.2015.
 */
 /*
@Entity
@NamedQuery(name = "Event.getAllEvents", query = "select e from Event e")
@SequenceGenerator(name = "SEQ_EVENT", initialValue = 50)
*/
public class Event {

    public Event(EventType type, String title, String description, Timestamp startPoint, Timestamp stopPoint) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.startPoint = startPoint;
        this.stopPoint = stopPoint;
    }

    public Event(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENT")
    int id;
    @NotNull
    EventType type;
    @NotNull @Min(5) @Max(25)
    String title;
    @NotNull
    String description;
    @NotNull
    Timestamp startPoint;
    @NotNull
    Timestamp stopPoint;

    @JoinColumn(name = "FK_SUBJECT")
    @Valid
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER) // cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<Subject> subjects;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Timestamp startPoint) {
        this.startPoint = startPoint;
    }

    public Timestamp getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(Timestamp stopPoint) {
        this.stopPoint = stopPoint;
    }




}
