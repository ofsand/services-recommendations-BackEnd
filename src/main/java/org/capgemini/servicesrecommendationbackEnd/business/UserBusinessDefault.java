package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Role;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.RoleRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserBusinessDefault implements UserBusiness{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final RecommendationMapper recommendationMapper;
    private final ServiceTradesPersonBusiness serviceTradesPersonBusiness;
    private final RecommendationRepository recommendationRepository;

    @Override
    public UserDto addUser(User user) {
        return recommendationMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto findUserById(Long userId) {
        return recommendationMapper.toUserDto(userRepository.getById(userId));
    }

    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.getById(roleId);
    }

    @Override
    public List<Role> addRoleToUser(Long userId, Long roleId) {
        UserDto user = findUserById(userId);
        List<Role> roleList = user.getRoles();
        roleList.add(findRoleById(roleId));
        user.setRoles(roleList);
        return roleList;
    }

    @Override
    public Recommendation recommend(User user, Long serviceTradesPersonId, Recommendation recommendation) {
        // filter if the user exist -> find by email
        /*
        recommendation.setServiceTradesPerson(serviceTradesPersonMapper.serviceTradesPersonDtoToServiceTradesPerson(serviceTradesPersonBusiness.findServiceTradesPersonById(serviceTradesPersonId)));
        List<Recommendation> recommendations = user.getRecommendations();
        recommendations.add(recommendation);
        user.setRecommendations(recommendations);
        return recommendationRepository.save(recommendation);
        */
        return null;
    }
}
