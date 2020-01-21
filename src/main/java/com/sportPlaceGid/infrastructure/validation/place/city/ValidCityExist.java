package com.sportPlaceGid.infrastructure.validation.place.city;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = CityExistConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidCityExist {

    String message() default "Данный город отсутствует в базе";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
