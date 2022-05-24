package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryBusinessDefault implements CategoryBusiness {

    private final CategoryRepository categoryRepository;
    private final RecommendationMapper recommendationMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return
            categoryRepository
                    .findAll()
                    .stream()
                    .map(recommendationMapper::toCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_USER));
        return recommendationMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = recommendationMapper.toCategory(categoryDto);
        return recommendationMapper.toCategoryDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        //Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        //return categoryMapper.categoryToCategoryDto(categoryRepository.save(category));
        return addCategory(categoryDto);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryDto categoryDto = recommendationMapper.toCategoryDto(categoryRepository.getById(id));
        categoryRepository.deleteById(id);

    }
}
