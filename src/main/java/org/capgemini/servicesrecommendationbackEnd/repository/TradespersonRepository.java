package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.capgemini.servicesrecommendationbackEnd.models.Tradesperson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradespersonRepository extends JpaRepository<Tradesperson, Long> {

}
