package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.models.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<CategoryDto> findAll() {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
    public CategoryDto findById(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public CategoryDto add(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{categoryId}")
    public CategoryDto update(@PathVariable Long categoryId ,@RequestBody CategoryDto categoryDto){
        categoryDto.setIdCategory(categoryId);
        categoryService.updateCategory(categoryDto);
        return categoryDto;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{categoryId}")
    public void delete(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}

