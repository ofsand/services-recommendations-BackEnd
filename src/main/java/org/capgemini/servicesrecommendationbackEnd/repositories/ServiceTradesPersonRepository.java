package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.Category;
import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceTradesPersonRepository extends JpaRepository<ServiceTradesPerson, Long> {
    List<ServiceTradesPerson> findByCategory(Category category);
}
