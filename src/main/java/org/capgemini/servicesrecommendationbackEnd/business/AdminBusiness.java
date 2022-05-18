package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminBusiness {

    @Autowired
    public RecommendationRepository recommendationRepository;

    public void approveRecommendation(Long recommendationId) {
        Recommendation recommendation = recommendationRepository.getById(recommendationId);
        recommendation.setApproved(true);
        recommendationRepository.save(recommendation);
    }


    public void declineRecommendation(Long recommendationId) {
        Recommendation recommendation = recommendationRepository.getById(recommendationId);
        recommendation.setApproved(false);
        recommendationRepository.save(recommendation);
    }
}
