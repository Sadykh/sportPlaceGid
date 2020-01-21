package com.sportPlaceGid.infrastructure.validation.place.category;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = CategoryExistConstraintValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ValidCategoryExist {

    String message() default "Данная категория отсутствует в базе";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
