package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Role;
import org.capgemini.servicesrecommendationbackEnd.models.ServiceTradesPerson;
import org.capgemini.servicesrecommendationbackEnd.models.User;

import java.util.List;

public interface UserBusiness {

    UserDto addUser(User user);
    User saveUser(User user);
    UserDto findUserById(Long userId);
    Role findRoleById(Long roleId);
    List<Role> addRoleToUser(Long userId, Long roleId);
    Recommendation recommend(User user,Long serviceTradesPersonId, Recommendation recommendation);

}
