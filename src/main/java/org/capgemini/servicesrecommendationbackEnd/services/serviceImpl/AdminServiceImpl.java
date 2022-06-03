package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.services.service.AdminService;
import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
import org.capgemini.servicesrecommendationbackEnd.repositories.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepository;
    private final RecommendationMapper recommendationMapper;

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

    @Override
    public List<UserDto> getAll() {
        return
            userRepository
                .findAll()
                .stream()
                .map(recommendationMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto add(User user) {
        return recommendationMapper.toUserDto(userRepository.save(user));
    }
}
