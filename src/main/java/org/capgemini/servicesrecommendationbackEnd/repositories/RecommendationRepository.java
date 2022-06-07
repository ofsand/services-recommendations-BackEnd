package org.capgemini.servicesrecommendationbackEnd.repositories;

import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

    @Query("select r from Recommendation r where r.serviceTradesPerson.id = :serviceTradespersonId")
    public List<Recommendation> getAllRecByServiceTradesperson(@Param("serviceTradespersonId") Long serviceTradespersonId);

    @Query("select r from Recommendation r where r.serviceTradesPerson.id = :serviceTradespersonId and isApproved = true")
    public List<Recommendation> getApprovedRecByServiceTradesperson(@Param("serviceTradespersonId") Long serviceTradespersonId);


    @Query("select r from Recommendation r where r.serviceTradesPerson.id = :serviceTradespersonId and isApproved = false")
    public List<Recommendation> getDisapprovedRecByServiceTradesperson(@Param("serviceTradespersonId") Long serviceTradespersonId);


    /*
    @Query("select r from Recommendation r where r.tradesperson.id = :tradespersonId and isApproved = true")
    public List<Recommendation> getRecommendationsByTradesperson(@Param("tradespersonId") Long tradespersonId);
    */
}
