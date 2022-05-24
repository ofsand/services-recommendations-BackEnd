package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.TradesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTradesPersonRepository extends JpaRepository<ServiceTradesPerson, Long> {

}
