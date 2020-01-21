package com.sportPlaceGid.infrastructure.validation.place.category;

import com.sportPlaceGid.domain.Category;
import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.infrastructure.service.CategoryService;
import com.sportPlaceGid.infrastructure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExistConstraintValidator implements ConstraintValidator<ValidCategoryExist, Long> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public void initialize(final ValidCategoryExist arg0) {

    }

    @Override
    public boolean isValid(final Long cityId, final ConstraintValidatorContext context) {
        try {
            Category category = categoryService.getById(cityId);
            return category.getName() != null;
        } catch (Throwable e) {
            return false;
        }
    }

}
