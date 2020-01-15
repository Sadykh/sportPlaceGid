package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import com.sportPlaceGid.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PreAuthorize("permitAll()")
    @PostMapping("/")
    public UserCreateDto addUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return userService.registerNewUserAccount(userCreateDto);
    }


}
