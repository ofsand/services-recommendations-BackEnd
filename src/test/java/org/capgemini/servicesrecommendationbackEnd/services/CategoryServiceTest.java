package org.capgemini.servicesrecommendationbackEnd.services;

import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.capgemini.servicesrecommendationbackEnd.repositories.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.services.serviceImpl.CategoryServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test the category service")
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @Spy
    private RecommendationMapper mapper = Mappers.getMapper(RecommendationMapper.class);
    @Mock
    private RecommendationMapper recommendationMapper;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    private static EasyRandom generator;
    @BeforeAll
    static void setup(){
        generator = new EasyRandom();
    }

    @Test
    @DisplayName("Test for get all categories")
    public void testGetAllCategories(){
        //Given
        generator = new EasyRandom();
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = mapper.toCategory(categoryDto);
        List<Category> categoryList =  new ArrayList<Category>();
        categoryList.add(category);

        // When
        when(categoryRepository.findAll()).thenReturn(categoryList);

        // Then
        assertEquals(1, categoryService.getAllCategories().size());
    }
    @Test
    @DisplayName("Test exception for get one category")
    public void testGetCategoryException() {
        // given
        generator = new EasyRandom();
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = mapper.toCategory(categoryDto);

        // When
        Mockito.lenient().when(categoryRepository.findById(123L)).thenReturn(Optional.of(category));
        Mockito.lenient().when(mapper.toCategoryDto(category)).thenReturn(categoryDto);
        Mockito.lenient().when(mapper.toCategory(categoryDto)).thenReturn(category);

        BusinessException exception =  assertThrows(BusinessException.class,()->{
            CategoryDto excpectedCategory = categoryService.getCategory(categoryDto.getIdCategory());
        });

        //Then
        String expectedMessage = "category not found";
        String cureentMessage = exception.getErrorsMessage().getMessage();
        assertEquals(expectedMessage,cureentMessage);


    }

    @Test
    @DisplayName("Test for get one category")
    public void testGetCategory(){
        // given
        generator = new EasyRandom();
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = mapper.toCategory(categoryDto);

        // When
        Mockito.lenient().when(categoryRepository.findById(categoryDto.getIdCategory())).thenReturn(Optional.of(category));
        Mockito.lenient().when(mapper.toCategoryDto(category)).thenReturn(categoryDto);
        Mockito.lenient().when(mapper.toCategory(categoryDto)).thenReturn(category);

        //Then
        CategoryDto excpectedCategory = categoryService.getCategory(categoryDto.getIdCategory());
        assertEquals(excpectedCategory,categoryDto);
    }

    @Test
    @DisplayName("Test for add category")
    public void testAddCategory(){
        //Given
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = mapper.toCategory(categoryDto);

        //When
        Mockito.lenient().when(categoryRepository.save(category)).thenReturn(category);
        Mockito.lenient().when(mapper.toCategoryDto(category)).thenReturn(categoryDto);
        Mockito.lenient().when(mapper.toCategory(categoryDto)).thenReturn(category);
        CategoryDto categoryFind = categoryService.addCategory(categoryDto);

        //Then
        verify(categoryRepository,times(1)).save(Mockito.any()) ;
        assertNotNull(categoryFind);
        assertEquals(categoryDto,categoryFind);
    }

}