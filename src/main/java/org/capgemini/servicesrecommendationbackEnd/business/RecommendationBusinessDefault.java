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
    public List<RecommendationDto> getAll() {
        return recommendationRepository.findAll().stream().map(recommendationMapper::recommendationToRecommendationDto).collect(Collectors.toList());
    }

    @Override
    public Recommendation get(Long recommendationId) {
        return null;
    }

    @Override
    public List<Recommendation> getRecommendationsByService(Long serviceId) {
        return null;
    }

    @Override
    public List<Recommendation> getRecommendationsByTradesperson(Long tradespersonId) {
        return null;
    }

    @Override
    public void addToService(Long serviceId, Recommendation recommendation) {

    }

    @Override
    public void addToTradesperson(Long tradespersonId, Recommendation recommendation) {

    }

    @Override
    public void update(Recommendation recommendation) {

    }

    @Override
    public void delete(Long recommendationId) {

    }
}
