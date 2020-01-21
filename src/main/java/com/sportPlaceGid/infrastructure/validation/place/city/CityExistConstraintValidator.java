package com.sportPlaceGid.infrastructure.validation.place.city;

import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.infrastructure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityExistConstraintValidator implements ConstraintValidator<ValidCityExist, Long> {

    @Autowired
    private CityService cityService;

    @Override
    public void initialize(final ValidCityExist arg0) {

    }

    @Override
    public boolean isValid(final Long cityId, final ConstraintValidatorContext context) {
        try {
            City city = cityService.getById(cityId);
            return city.getName() != null;
        } catch (Throwable e) {
            return false;
        }
    }

}
