package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategory(Long id) ;
    public CategoryDto addCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto);
    public void deleteCategory(Long id);
}
