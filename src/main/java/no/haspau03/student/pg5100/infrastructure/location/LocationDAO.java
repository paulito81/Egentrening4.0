package no.haspau03.student.pg5100.infrastructure.location;

import no.haspau03.student.pg5100.model.Location;

import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public interface LocationDAO {

    Location persistLocation(Location location);
    Location findByID(int id);
    List<Location> getAllLocations();
    List<Location> getAllDetachedLocations();
    boolean removeLocation(int id);
}
