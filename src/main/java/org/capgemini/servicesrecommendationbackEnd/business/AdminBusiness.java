package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.User;

import java.util.List;

public interface AdminBusiness {
    void approveRecommendation(Long recommendationId);
    void declineRecommendation(Long recommendationId);
    List<UserDto> getAll();
    UserDto add(User user);

}
