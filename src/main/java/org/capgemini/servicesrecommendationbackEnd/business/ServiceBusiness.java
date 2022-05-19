package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.repository.CategoryRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceBusiness implements EntityBusiness<Service, Long> {

    @Autowired
    public ServiceRepository serviceRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<Service> getAll() {
        return null;
    }

    @Override
    public Service get(Long id) {
        return serviceRepository.getById(id);
    }


    @Override
    public void add(Service objet) {

    }

    public void add(Long categoryId, Service service) {
        Category category = categoryRepository.getById(categoryId);
        service.setCategory(category);
        serviceRepository.save(service);
    }


    @Override
    public void update(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }
}
