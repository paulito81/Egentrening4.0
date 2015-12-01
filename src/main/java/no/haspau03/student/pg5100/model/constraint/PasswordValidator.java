package no.haspau03.student.pg5100.model.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Paul on 18.11.2015.
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {


    @Override
    public void initialize(ValidPassword validPassword) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if( password == null)
        return false;

        boolean containsNumOfL = password.matches("(?=\\S+$).{8,}$");
        boolean containsSpesialL = password.matches((".*[@#$%^+&=]"));
        boolean containsUpperCase = password.matches((".*([A-Z]).*"));
        boolean containsLowerCase = password.matches(".*([a-z]).*");
        boolean containsNumber = password.matches(".*([0-9]).*");
        return ( containsUpperCase && containsLowerCase && containsNumber && containsNumOfL && containsSpesialL);
    }
}
