package com.sportPlaceGid;

import com.sportPlaceGid.infrastructure.dto.category.CategoryCreateDto;
import com.sportPlaceGid.infrastructure.dto.city.CityCreateDto;
import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import com.sportPlaceGid.infrastructure.service.CategoryService;
import com.sportPlaceGid.infrastructure.service.CityService;
import com.sportPlaceGid.infrastructure.service.PlaceManagerService;
import com.sportPlaceGid.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SportPlaceGidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportPlaceGidApplication.class, args);
    }

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PlaceManagerService placeService;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            this.initUsers();
            this.initCategory();
            this.initCity();
            this.initPlaceRouterLevel();
        };
    }

    public void initUsers() {
        try {
            userService.registerNewUserAccount(new UserCreateDto("admin@test1.ru", "Test1", "qwerty"));
        } catch (final Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Пользователь возможно уже есть");
        }
    }

    public void initCategory() {
        categoryService.createCategory(new CategoryCreateDto("Дрифт площадки"));
        categoryService.createCategory(new CategoryCreateDto("Горнолыжные площадки"));
        categoryService.createCategory(new CategoryCreateDto("Картинг"));
        categoryService.createCategory(new CategoryCreateDto("JDM площадки"));
        categoryService.createCategory(new CategoryCreateDto("Роллердром"));
        categoryService.createCategory(new CategoryCreateDto("Скейт парки"));
    }

    public void initCity() {
        cityService.create(new CityCreateDto("Москва"));
        cityService.create(new CityCreateDto("Санкт-Петербург"));
        cityService.create(new CityCreateDto("Сочи"));
        cityService.create(new CityCreateDto("Казань"));
        cityService.create(new CityCreateDto("Магнитогорск"));
        cityService.create(new CityCreateDto("Выборг"));
        cityService.create(new CityCreateDto("Карелия"));
    }

    public void initPlaceRouterLevel() {
        placeService.createPlaceRouterLevel("Легкая");
        placeService.createPlaceRouterLevel("Зеленая");
        placeService.createPlaceRouterLevel("Красная");
        placeService.createPlaceRouterLevel("Средняя");
        placeService.createPlaceRouterLevel("Черная");
        placeService.createPlaceRouterLevel("Сложная");
    }
}
