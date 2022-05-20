package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.CategoryBusiness;
import org.capgemini.servicesrecommendationbackEnd.dto.CategoryDto;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryBusiness categoryBusiness;


    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<CategoryDto> findAll() {
        return categoryBusiness.getAllCategories();
    }

    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.GET)
    public CategoryDto findById(@PathVariable Long categoryId) {
        return categoryBusiness.getCategory(categoryId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public CategoryDto add(@RequestBody CategoryDto categoryDto){
        return categoryBusiness.addCategory(categoryDto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{categoryId}")
    public CategoryDto update(@PathVariable Long categoryId ,@RequestBody CategoryDto categoryDto){
        categoryDto.setIdCategory(categoryId);
        categoryBusiness.updateCategory(categoryDto);
        return categoryDto;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{categoryId}")
    public void delete(@PathVariable Long categoryId){
        categoryBusiness.deleteCategory(categoryId);
    }
}

