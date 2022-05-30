package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessageException;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.CategoryService;
import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.capgemini.servicesrecommendationbackEnd.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final RecommendationMapper recommendationMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return
            categoryRepository
                .findAll()
                .stream()
                .map(recommendationMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        //        .orElseThrow(() -> new BusinessException(ErrorsMessageException.NOT_FOUND_USER))
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
        categoryRepository.deleteById(id);
    }
}
