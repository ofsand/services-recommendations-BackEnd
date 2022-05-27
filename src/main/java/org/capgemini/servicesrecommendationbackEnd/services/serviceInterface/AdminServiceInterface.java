package org.capgemini.servicesrecommendationbackEnd.services.serviceInterface;

import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;

import java.util.List;

public interface AdminServiceInterface {
    void approveRecommendation(Long recommendationId);
    void declineRecommendation(Long recommendationId);
    List<UserDto> getAll();

    UserDto add(User user);
}