package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.CategoryMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test the categorie business")
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CategoryBusinessDefaultTest {
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryBusinessDefault categoryBusinessDefault;

    private static EasyRandom generator;
    @BeforeAll
    static void setup(){
       generator = new EasyRandom();
    }
    @Test
    @DisplayName("Add category")
    public void testAddCategory(){
        //Given
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        //Category category = generator.nextObject(Category.class);
        //var category = generator.nextObject(Category.class);
        //CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category);
        //When
        //when(categoryRepository.save(Mockito.any(Category.class))).thenReturn(Mockito.any(Category.class));
        //when(categoryMapper.categoryToCategoryDto(Mockito.any(Category.class))).thenReturn(categoryDto);
        //when(categoryMapper.categoryDtoToCategory(categoryDto)).thenReturn(Mockito.any());
        //----
        when(categoryRepository.save(Mockito.any())).thenReturn(category);
        when(categoryMapper.categoryToCategoryDto(Mockito.any())).thenReturn(categoryDto);
        when(categoryMapper.categoryDtoToCategory(categoryDto)).thenReturn(Mockito.any());
       // when(categoryRepository.save(Mockito.any())).thenReturn(categoryDto);
        CategoryDto categoryFind = categoryBusinessDefault.addCategory(categoryDto);
        //System.out.println(categoryDto);
        //Then
        verify(categoryRepository,times(1)).save(Mockito.any()) ;
        assertNotNull(categoryFind);
        assertEquals(categoryDto,categoryFind);
    }

    @Test
    @DisplayName("Get category by Id")
    public void testGetCategory(){
        //Given
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);

        // When
        when(categoryRepository.getById(categoryDto.getIdCategory())).thenReturn(category);
        when(categoryMapper.categoryToCategoryDto(Mockito.any())).thenReturn(categoryDto);
        when(categoryMapper.categoryDtoToCategory(Mockito.any())).thenReturn(category);
        // test exception
       /* BusinessException exception =  assertThrows(BusinessException.class,()->{
        });
        String expectedMessage = "user not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));*/
        //---
        CategoryDto excpectedCategory = categoryBusinessDefault.getCategory(categoryDto.getIdCategory());
        //System.out.println(excpectedCategory);
        // Then
        assertNotNull(excpectedCategory);
        assertEquals(excpectedCategory,categoryDto);
        //verify(categoryRepository).getById(categoryDto.getIdCategory());
    }

    @Test
    @DisplayName("Get all categories")
    public void testGetAllCategories(){
        //Given
        CategoryDto categoryDto = generator.nextObject(CategoryDto.class);
        Category category = categoryMapper.categoryDtoToCategory(categoryDto);
        List<Category> categoryList =  new ArrayList<Category>();
        categoryList.add(category);

        // When
        when(categoryRepository.findAll()).thenReturn(categoryList);

        // Then
        assertEquals(1, categoryBusinessDefault.getAllCategories().size());
    }
/*
    @Test
    @DisplayName("Update category")
    public void testUpdate(){
        //Given
        var cat = generator.nextObject(Category.class);

        //When
        when(categoryRepository.save(Mockito.any())).thenReturn(cat);
        var  categoryFind = categoryBusinessDefault.update(cat);

        //Then
        assertNotNull(categoryFind);
        assertEquals(cat,categoryFind );
    }

    @Test
    @DisplayName("Delete category")
    public void testDelete(){
        //Given
        var cat = generator.nextObject(Category.class);
        List<Category> categoryList =  new ArrayList<Category>();
        categoryList.add(cat);

        // When
        categoryRepository.deleteById(cat.getIdCategory());
        Category categoryFind = categoryBusinessDefault.getOne(cat.getIdCategory());

        // Then
        assertNull(categoryFind);
    }

*/
}
