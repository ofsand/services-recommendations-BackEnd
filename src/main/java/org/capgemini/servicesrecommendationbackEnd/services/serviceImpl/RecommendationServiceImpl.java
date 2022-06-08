package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.dto.RecommendationDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.entities.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
import org.capgemini.servicesrecommendationbackEnd.repositories.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repositories.ServiceTradesPersonRepository;
import org.capgemini.servicesrecommendationbackEnd.services.service.RecommendationService;
import org.capgemini.servicesrecommendationbackEnd.services.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;
    private final ServiceTradesPersonRepository serviceTradesPersonRepository;
    private final UserService userService;

    @Override
    public List<RecommendationDto> getAllRecommendations() {
        return recommendationRepository.findAll()
                .stream()
                .map(recommendationMapper::toRecommendationDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendationDto getRecommendation(Long recommendationId) {
        Recommendation recommendation = recommendationRepository
                .findById(recommendationId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));

        return recommendationMapper.toRecommendationDto(recommendation);
    }

    @Override
    public List<RecommendationDto> getDisapprovedRecommendations() {
        return recommendationRepository.findAll()
                .stream()
                .filter(recommendation -> !recommendation.isApproved())
                .map(recommendationMapper::toRecommendationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecommendationDto> getRecommendationsByServiceTradesperson(Long serviceTradespersonId) {
        // Delegate the process to the repository layer and getting all approved recommendations
        List<Recommendation> recommendations = recommendationRepository.getApprovedRecByServiceTradesperson(serviceTradespersonId);

        return recommendations.stream()
                .map(recommendationMapper::toRecommendationDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendationDto addRecommendationToServiceTradesperson(Long ServiceTradespersonId, RecommendationDto recommendationDto) {
        // Get the corresponding ServiceTradesPerson
        ServiceTradesPerson serviceTradesperson = serviceTradesPersonRepository
                .findById(ServiceTradespersonId)
                .orElseThrow(() -> new BusinessException(ErrorsMessage.NOT_FOUND_ID));

        //
        User user = recommendationMapper.toUser(recommendationDto.getUser());
        User savedUser = recommendationMapper.toUser(userService.addUser(user));

        // Set the founded ServiceTradesPerson to the Recommendation
        Recommendation recommendation = recommendationMapper.toRecommendation(recommendationDto);
        recommendation.setServiceTradesPerson(serviceTradesperson);
        recommendation.setUser(savedUser);

        // Save the new Recommendation
        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        return recommendationMapper.toRecommendationDto(savedRecommendation);
    }
}
