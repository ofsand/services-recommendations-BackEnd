package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
   /*
    @Query("select r from Recommendation r where r.service.id = :serviceId and isApproved = true")
    public List<Recommendation> getRecommendationsByService(@Param("serviceId") Long serviceId);

    @Query("select r from Recommendation r where r.tradesperson.id = :tradespersonId and isApproved = true")
    public List<Recommendation> getRecommendationsByTradesperson(@Param("tradespersonId") Long tradespersonId);
    */
}
