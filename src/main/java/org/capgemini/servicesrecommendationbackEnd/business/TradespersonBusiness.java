package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.TradespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class TradespersonBusiness implements EntityBusiness<Tradesperson, Long> {


    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public TradespersonRepository tradespersonRepository;

    @Override
    public List<Tradesperson> getAll() {
        return null;
    }

    @Override
    public Tradesperson get(Long id) {
        return tradespersonRepository.getById(id);
    }

    @Override
    public void add(Tradesperson objet) {

    }


    public void add(Long categoryId, Tradesperson objet) {
        Category category = categoryRepository.getById(categoryId);
        objet.setCategory(category);
        tradespersonRepository.save(objet);
    }

    @Override
    public void update(Tradesperson object) {
        tradespersonRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        tradespersonRepository.deleteById(id);
    }
}
