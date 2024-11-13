package org.wora.wrm.utils.annotations.exist;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Exist {

    String message() default "Entity With This Id Does Not Exist";
    Class<?> entity();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
