package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CategoryMapper {
    CategoryDto categoryToCategoryDto(Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);
}
