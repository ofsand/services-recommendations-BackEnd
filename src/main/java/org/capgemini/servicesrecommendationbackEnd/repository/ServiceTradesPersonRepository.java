package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Category;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceTradesPersonRepository extends JpaRepository<ServiceTradesPerson, Long> {
    List<ServiceTradesPerson> findByCategory(Category category);
}
