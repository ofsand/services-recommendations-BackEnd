package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryBusiness implements EntityBusiness<Category, Long> {

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public void add(Category objet) {
        categoryRepository.save(objet);
    }

    @Override
    public void update(Category object) {
        categoryRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
