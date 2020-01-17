package com.sportPlaceGid.infrastructure.repository;

import com.sportPlaceGid.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);
}
