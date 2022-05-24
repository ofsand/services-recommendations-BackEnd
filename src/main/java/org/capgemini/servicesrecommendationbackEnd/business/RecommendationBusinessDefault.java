package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.ServiceTradesPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationBusinessDefault implements RecommendationBusiness {
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;
    private final ServiceTradesPersonRepository serviceTradesPersonRepository;

    @Override
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationRepository.findAll()
                .stream()
                .map(recommendationMapper::recommendationToRecommendationDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendationDto getRecommendation(Long recommendationId) {
        Recommendation recommendation = recommendationRepository
                .findById(recommendationId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));

        return recommendationMapper.recommendationToRecommendationDto(recommendation);
    }

    @Override
    public List<RecommendationDto> getRecommendationsByServiceTradesperson(Long serviceTradespersonId) {
        // Delegate the process to the repository layer
        List<Recommendation> recommendations = recommendationRepository.getRecommendationsByServiceTradesperson(serviceTradespersonId);

        return recommendations.stream()
                .map(recommendationMapper::recommendationToRecommendationDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, RecommendationDto recommendationDto) {
        // Get the corresponding ServiceTradesPerson
        ServiceTradesPerson serviceTradesperson = serviceTradesPersonRepository
                .findById(ServiceTradespersonId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));

        // Set the founded ServiceTradesPerson to the Recommendation
        Recommendation recommendation = recommendationMapper.recommendationDtoToRecommendation(recommendationDto);
        recommendation.setServiceTradesPerson(serviceTradesperson);

        // Save the new Recommendation
        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return recommendationMapper.recommendationToRecommendationDto(savedRecommendation);
    }


}
