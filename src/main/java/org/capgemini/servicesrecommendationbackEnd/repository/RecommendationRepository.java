package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

}
