package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.TradespersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TradespersonBusinessDefault implements TradespersonBusiness {

    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public TradespersonRepository tradespersonRepository;

    @Override
    public List<Tradesperson> getAll() {
        return tradespersonRepository.findAll();
    }

    @Override
    public Tradesperson get(Long id) {
        return tradespersonRepository.getById(id);
    }


    public void add(Long categoryId, Tradesperson tradesperson) {
        Category category = categoryRepository.getById(categoryId);
        tradesperson.setCategory(category);
        tradespersonRepository.save(tradesperson);
    }

    @Override
    public void update(Tradesperson tradesperson) {
        tradespersonRepository.save(tradesperson);
    }

    @Override
    public void delete(Long id) {
        tradespersonRepository.deleteById(id);
    }
}
