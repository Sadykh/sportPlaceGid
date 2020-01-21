package com.sportPlaceGid.infrastructure.validation.user.email;

import com.sportPlaceGid.domain.User;
import com.sportPlaceGid.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueConstraintValidator implements ConstraintValidator<ValidEmailUnique, String> {

    @Autowired
    private UserService userService;

    @Override
    public void initialize(final ValidEmailUnique arg0) {

    }

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {
        if (email.isEmpty()) {
            return true;
        }
        User user = userService.findByEmail(email);
        return user == null;
    }

}
