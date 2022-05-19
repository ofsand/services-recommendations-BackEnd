package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;

import java.util.List;

public interface CategoryBusiness {
    public List<Category> getAll();
    public Category get(Long id) ;
    public void add(Category category);
    public void update(Category category);
    public void delete(Long id);
}
