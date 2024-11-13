package org.wora.wrm.utils.annotations.uniqueField;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueFieldValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueField {

    String message() default "This Field Must Be Unique, A Duplicate Already Exist";
    Class<?> entity();
    String fieldName();

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
