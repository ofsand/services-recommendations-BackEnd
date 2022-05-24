package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminBusinessDefault implements AdminBusiness{

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
