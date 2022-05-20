package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.Category;

import java.util.List;

public interface CategoryBusiness {
    public List<CategoryDto> getAll();
    public CategoryDto get(Long id) ;
    public CategoryDto add(Category category);
    public void update(Category category);
    public void delete(Long id);
}
