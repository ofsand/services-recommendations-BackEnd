package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Test the categorie business")
@ExtendWith(MockitoExtension.class)
class CategoryBusinessDefaultTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryBusinessDefault categoryBusinessDefault;

    private static EasyRandom generator;
    @BeforeAll
    static void setup(){
       generator = new EasyRandom();

    }
    @Test
    @DisplayName("Add category")
    public void testAdd(){
        //Given
        var cat = generator.nextObject(Category.class);

        //When
        when(categoryRepository.save(Mockito.any())).thenReturn(cat);
        var  categoryFind = categoryBusinessDefault.add(cat);

        //Then
        verify(categoryRepository,times(1)).save(cat) ;
        assertNotNull(categoryFind);
        assertEquals(cat,categoryFind );
    }
    @Test
    @DisplayName("Get category by Id")
    public void testGetOne(){
        //Given
        var cat = generator.nextObject(Category.class);

        // When
        when(categoryRepository.getById(cat.getIdCategory())).thenReturn(cat);
        Category excpect = categoryBusinessDefault.getOne(cat.getIdCategory());

        // Then
        assertEquals(excpect,cat);
        verify(categoryRepository).getById(cat.getIdCategory());
    }

    @Test
    @DisplayName("Get all categories")
    public void testGetAll(){
        //Given
        var cat = generator.nextObject(Category.class);
        //List<Category> categoryList = generator.objects(Category.class,5).collect(Collectors.toList());
        List<Category> categoryList =  new ArrayList<Category>();
        categoryList.add(cat);

        // When
        when(categoryRepository.findAll()).thenReturn(categoryList);

        // Then
        assertEquals(1, categoryBusinessDefault.getAll().size());
    }

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
}
