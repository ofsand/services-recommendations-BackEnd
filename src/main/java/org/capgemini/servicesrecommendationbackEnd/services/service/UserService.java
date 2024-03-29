package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;

public interface UserService {

    UserDto addUser(User user);
    UserDto findUserById(Long userId);
    Role findRoleById(Long roleId);
    void addRoleToUser(Long userId, Long roleId);
    Recommendation recommend(User user,Long serviceTradesPersonId, Recommendation recommendation);

}
