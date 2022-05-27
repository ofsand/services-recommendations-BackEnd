package org.capgemini.servicesrecommendationbackEnd.services.serviceInterface;

import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;

import java.util.List;

public interface CategoryServiceInterface {
    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategory(Long id) ;
    public CategoryDto addCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto);
    public void deleteCategory(Long id);
}
