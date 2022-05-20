package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;

import java.util.List;

public interface CategoryBusiness {
    public List<Category> getAll();
    public Category getOne(Long id) ;
    public Category add(Category category);
    public Category update(Category category);
    public void delete(Long id);
}
