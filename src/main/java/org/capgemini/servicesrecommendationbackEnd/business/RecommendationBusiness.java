package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;

import java.util.List;

public interface RecommendationBusiness {
    List<RecommendationDto> getAllRecommendations();
    RecommendationDto getRecommendation(Long recommendationId);
    List<RecommendationDto> getRecommendationsByServiceTradesperson(Long serviceTradespersonId);
    RecommendationDto addRecommendationToServiceTradesperson(Long serviceTradespersonId, RecommendationDto recommendationDto);
}
