package org.capgemini.servicesrecommendationbackEnd;

import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.capgemini.servicesrecommendationbackEnd.repositories.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.services.serviceImpl.CategoryServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DisplayName("Test the categorie business")
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserMapperDefaultTest {
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private RecommendationMapper mapper = Mappers.getMapper(RecommendationMapper.class);

    @Test
    @DisplayName("Add category")
    public void testAddUser(){
        EasyRandom easyRandom = new EasyRandom();
        CategoryDto categoryDto = easyRandom.nextObject(CategoryDto.class);
        Category category = mapper.toCategory(categoryDto);
        Mockito.lenient().when(categoryRepository.save(category)).thenReturn(category);
        Mockito.lenient().when(mapper.toCategoryDto(category)).thenReturn(categoryDto);
        Mockito.lenient().when(mapper.toCategory(categoryDto)).thenReturn(category);

        CategoryDto categoryFind = categoryService.addCategory(categoryDto);
        assertNotNull(categoryFind);
        assertEquals(categoryDto,categoryFind);
        assertNotNull(categoryFind);
        assertEquals(categoryDto,categoryFind);
    }
}