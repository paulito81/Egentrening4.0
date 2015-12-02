package no.haspau03.student.pg5100.controller;

import no.haspau03.student.pg5100.infrastructure.location.LocationDAO;
import no.haspau03.student.pg5100.model.Location;

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
public class LocationController {

    @Inject
    private LocationDAO locationDAO;

    private int selectedId;
    private Location location;

    @PostConstruct
    public void init(){
        location = new Location();
    }

    public void persistNewLocation(){

        locationDAO.persist(location);
    }

    public List<Location> getAllLocations(){

        return locationDAO.getAll();
    }

    public void findLocationById(){
       location = locationDAO.findByID(selectedId);
    }
    public void deleteLocationById(){
         locationDAO.removeLocation(selectedId);
    }

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public Location getLocation() {

        return location;
    }
    public List<SelectItem> getLocations2(){
        List<Location> locations = getAllLocations();
        return locations.stream().map(l -> new SelectItem(l.getId(), l.getBuilding() + " -" + l.getBuilding())).collect(Collectors.toList()) ;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public String getSelectedLocation(){
        return location.getRoom();
    }

}
