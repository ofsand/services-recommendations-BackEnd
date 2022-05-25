package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;

import java.util.List;

public interface CategoryBusiness {
    public List<CategoryDto> getAllCategories();
    public CategoryDto getCategory(Long id) ;
    public CategoryDto addCategory(CategoryDto categoryDto);
    public CategoryDto updateCategory(CategoryDto categoryDto);
    public void deleteCategory(Long id);
}
