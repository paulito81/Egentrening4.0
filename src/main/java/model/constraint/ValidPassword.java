package model.constraint;

import com.sun.xml.internal.ws.api.pipe.PipelineAssembler;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.ws.rs.ConstrainedTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Paul on 18.11.2015.
 */
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Invalid password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
