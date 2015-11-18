package infrastructure.subject;

import model.Location;
import model.User;

import javax.jms.Topic;
import java.util.List;

/**
 * Created by Paul on 18.11.2015.
 */
public interface SubjectDAO {

    boolean createNewLocation(Location location);
    Location getLocationByID(int id);
    List<User> getAllUserByTopic(Topic topic);

}
