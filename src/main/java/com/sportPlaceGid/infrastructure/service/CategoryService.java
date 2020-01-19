package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.Category;
import com.sportPlaceGid.infrastructure.dto.category.CategoryCreateDto;
import com.sportPlaceGid.infrastructure.dto.user.UserCreateDto;
import com.sportPlaceGid.infrastructure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryCreateDto createCategory(final CategoryCreateDto dto) {
        final Category category = new Category(dto.getName());
        try {
            categoryRepository.save(category);
        } catch (final Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Категория возможно уже есть");
        }
        dto.setId(category.getId());
        return dto;
    }


    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    public Category getById(Long id) {
        return this.categoryRepository.getOne(id);
    }
}
