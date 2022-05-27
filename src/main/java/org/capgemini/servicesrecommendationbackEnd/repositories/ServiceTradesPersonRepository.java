package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTradesPersonRepository extends JpaRepository<ServiceTradesPerson, Long> {

}
