package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.domain.Category;
import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import com.sportPlaceGid.infrastructure.service.CategoryService;
import com.sportPlaceGid.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public List<Category> index() {
        return categoryService.getAll();
    }

}
