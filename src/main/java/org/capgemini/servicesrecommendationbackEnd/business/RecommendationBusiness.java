package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;

import java.util.List;

public interface RecommendationBusiness {
    public List<RecommendationDto> getAllRecommendations();
    public RecommendationDto getRecommendation(Long recommendationId);
    public List<RecommendationDto> getRecommendationsByServiceTradesperson(Long ServiceTradespersonId);
    public RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, Recommendation recommendation);
    public RecommendationDto updateRecommendation(Recommendation recommendation);
    public void deleteRecommendation(Long recommendationId);
}
