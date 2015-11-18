package infrastructure;

import model.User;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Paul on 18.11.2015.
 */
public class UserTest {

    private Validator validator;

    @Before
    public void setUp() throws Exception{
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void nullValueUser() throws Exception{
        User user = new User();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(4, violations.size());
    }

    @Test
    public void invalidUser() throws Exception{
        User user = new User();
        user.setEmail("test");
        user.setPassword("1aL3123!");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertEquals(3, violations.size());
    }

    @Test
    public void validUser() throws Exception{
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("abC123");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(!violations.isEmpty());
    }

}
