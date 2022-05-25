package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.CategoryMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryBusinessDefault implements CategoryBusiness {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return
            categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_USER));
        return categoryMapper.categoryToCategoryDto(category);
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        if(categoryDto.getIdCategory().equals("")){
            //servcie 2
        }else{

            //service 3
        }
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        return categoryMapper.categoryToCategoryDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        //Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        //return categoryMapper.categoryToCategoryDto(categoryRepository.save(category));
        return addCategory(categoryDto);
    }

    @Override
    public void deleteCategory(Long id) {
        CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(categoryRepository.getById(id));
        categoryRepository.deleteById(id);

    }
}
