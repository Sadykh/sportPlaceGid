package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.SportPlaceGidApplication;
import com.sportPlaceGid.domain.User;
import com.sportPlaceGid.infrastructure.repository.UserRepository;
import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(SportPlaceGidApplication.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserCreateDto registerNewUserAccount(final UserCreateDto dto) {
        String passwordHash = passwordEncoder.encode(dto.getPassword());
        final User user = new User(dto.getEmail(), passwordHash, dto.getName());
        userRepository.save(user);
        dto.setId(user.getId());
        dto.setPassword(null);
        return dto;
    }

    public Page<User> getAll(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    public User getOneById(long id) {
        return userRepository.getOne(id);
    }


    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
