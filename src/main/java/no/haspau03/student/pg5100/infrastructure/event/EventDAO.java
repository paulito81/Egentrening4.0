package no.haspau03.student.pg5100.infrastructure.event;

import no.haspau03.student.pg5100.model.Event;

import java.util.List;

/**
 * Created by Paul on 03.12.2015.
 */
public interface EventDAO {

        Event persistEvent(Event event);
        List<Event> getAllEvents();
        Event detailedEvent(int id);

}
