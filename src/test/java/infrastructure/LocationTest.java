package infrastructure;

import junit.framework.Assert;
import model.Location;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by Paul on 18.11.2015.
 */
public class LocationTest {
    private Validator validator;

    @Before
    public void setUp() throws Exception{
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void invalidLocation() throws Exception{

        Location location = new Location();
        Set<ConstraintViolation<Location>> violations = validator.validate(location);
        Assert.assertEquals(2, violations.size());
    }
    @Test
    public void validLocation() throws Exception{
        Location location = new Location();
        location.setBuilding("Galleriet");
        location.setRoom("72");
        Set<ConstraintViolation<Location>> violations = validator.validate(location);
        Assert.assertTrue(violations.isEmpty());
    }

}
