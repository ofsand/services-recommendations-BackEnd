package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
   /*
    @Query("select r from Recommendation r where r.service.id = :serviceId and isApproved = true")
    public List<Recommendation> getRecommendationsByService(@Param("serviceId") Long serviceId);

    @Query("select r from Recommendation r where r.tradesperson.id = :tradespersonId and isApproved = true")
    public List<Recommendation> getRecommendationsByTradesperson(@Param("tradespersonId") Long tradespersonId);
    */

}
