package com.sportPlaceGid.infrastructure.repository;

import com.sportPlaceGid.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
