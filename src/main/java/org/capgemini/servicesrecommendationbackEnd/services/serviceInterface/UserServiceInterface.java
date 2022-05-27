package org.capgemini.servicesrecommendationbackEnd.services.serviceInterface;

import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;

import java.util.List;

public interface UserServiceInterface {

    UserDto addUser(User user);
    User saveUser(User user);
    UserDto findUserById(Long userId);
    Role findRoleById(Long roleId);
    List<Role> addRoleToUser(Long userId, Long roleId);
    Recommendation recommend(User user,Long serviceTradesPersonId, Recommendation recommendation);

}
