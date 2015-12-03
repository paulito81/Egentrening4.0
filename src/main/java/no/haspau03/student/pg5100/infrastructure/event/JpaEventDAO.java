package no.haspau03.student.pg5100.infrastructure.event;

import no.haspau03.student.pg5100.model.Event;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Paul on 03.12.2015.
 */
@Stateless
public class JpaEventDAO implements EventDAO{
    @Override
    public Event persistEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public Event detailedEvent(int id) {
        return null;
    }
}
