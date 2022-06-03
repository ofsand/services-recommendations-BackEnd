package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.services.service.RecommendationService;
import org.capgemini.servicesrecommendationbackEnd.models.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.repositories.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    @Override
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationRepository.findAll().stream().map(recommendationMapper::toRecommendationDto).collect(Collectors.toList());
    }

    @Override
    public RecommendationDto getRecommendation(Long recommendationId) {
        return null;
    }

    @Override
    public List<RecommendationDto> getRecommendationsByServiceTradesperson(Long ServiceTradespersonId) {
        return null;
    }

    @Override
    public RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, Recommendation recommendation) {
        return null;
    }


}
