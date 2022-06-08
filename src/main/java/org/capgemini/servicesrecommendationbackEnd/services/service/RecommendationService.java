package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<RecommendationDto> getAllRecommendations();
    RecommendationDto getRecommendation(Long recommendationId);

    List<RecommendationDto> getDisapprovedRecommendations();

    List<RecommendationDto> getAllRecByServiceTradesperson(Long serviceTradespersonId);

    List<RecommendationDto> getApprovedRecByServiceTradesperson(Long ServiceTradespersonId);

    RecommendationDto getOneRecByServiceTradesperson(Long serviceTradespersonId, Long recommendationId);
    RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, RecommendationDto recommendationDto);

    RecommendationDto approveRecommendation(Long recommendationId);
    RecommendationDto declineRecommendation(Long recommendationId);
}
