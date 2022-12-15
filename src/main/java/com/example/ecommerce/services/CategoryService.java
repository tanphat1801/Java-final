package com.example.ecommerce.services;

import com.example.ecommerce.models.Category;
import com.example.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }
}
