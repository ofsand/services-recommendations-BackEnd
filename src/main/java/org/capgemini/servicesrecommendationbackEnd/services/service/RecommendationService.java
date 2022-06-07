package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<RecommendationDto> getAllRecommendations();
    RecommendationDto getRecommendation(Long recommendationId);
    List<RecommendationDto> getRecommendationsByServiceTradesperson(Long ServiceTradespersonId);
    RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, RecommendationDto recommendationDto);
}
