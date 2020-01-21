package com.sportPlaceGid.infrastructure.validation.user.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = EmailUniqueConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidEmailUnique {

    String message() default "Email неправильный или уже занят";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
