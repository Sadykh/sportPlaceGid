package com.sportPlaceGid;

import com.sportPlaceGid.domain.User;
import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import com.sportPlaceGid.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class SportPlaceGidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlaceGidApplication.class, args);
    }


    @Autowired
    private UserService userService;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            try {
				userService.registerNewUserAccount(new UserCreateDto("admin@test1.ru", "Test1", "qwerty"));
			}  catch (final Exception e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Пользователь возможно уже есть");
            }
        };
    }
}
