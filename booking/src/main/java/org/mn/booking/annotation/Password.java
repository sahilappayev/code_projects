package org.mn.booking.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Pattern(regexp = "^[A-Za-z0-9]{6,50}$", message = "{password.message}")
@Constraint(validatedBy = { })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    String message() default "Password is incorrect!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
