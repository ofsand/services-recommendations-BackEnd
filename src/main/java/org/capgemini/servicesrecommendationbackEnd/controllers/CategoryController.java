package org.capgemini.servicesrecommendationbackEnd.controllers;

import org.capgemini.servicesrecommendationbackEnd.business.CategoryBusiness;
import org.capgemini.servicesrecommendationbackEnd.business.TradespersonBusiness;
import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @RequestMapping(method = RequestMethod.GET ,value = "/categories")
    public List<Category> getAll() {return categoryBusiness.getAll();}

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}")
    public Category get(@PathVariable Long categoryId) {return categoryBusiness.get(categoryId);}

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody Category category){
        categoryBusiness.add(category);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{categoryId}")
    public void update(@PathVariable Long categoryId ,@RequestBody Category category){
        category.setIdCategory(categoryId);
        categoryBusiness.update(category);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{categoryId}")
    public void delete(@PathVariable Long categoryId){
        categoryBusiness.delete(categoryId);
    }
}
