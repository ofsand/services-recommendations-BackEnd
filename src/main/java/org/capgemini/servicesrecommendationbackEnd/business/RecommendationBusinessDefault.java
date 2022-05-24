package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationBusinessDefault implements RecommendationBusiness {
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    @Override
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationRepository.findAll().stream().map(recommendationMapper::recommendationToRecommendationDto).collect(Collectors.toList());
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
