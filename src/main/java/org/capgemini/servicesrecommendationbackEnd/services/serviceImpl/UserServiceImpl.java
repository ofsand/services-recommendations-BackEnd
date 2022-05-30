package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.capgemini.servicesrecommendationbackEnd.mapper.RecommendationMapper;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.ServiceTradesPersonService;
import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
import org.capgemini.servicesrecommendationbackEnd.repositories.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repositories.RoleRepository;
import org.capgemini.servicesrecommendationbackEnd.repositories.UserRepository;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ServiceTradesPersonService serviceTradesPersonBusiness;
    private final RecommendationRepository recommendationRepository;
    private final PasswordEncoder passwordEncoder;

    private final RecommendationMapper recommendationMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null)
        {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found in database");
        } else {
            log.info("User found in the database ! {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }

    @Override
    public UserDto addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public void addRoleToUser(Long userId, Long roleId) {
        UserDto userDto = findUserById(userId);
        Role role = findRoleById(roleId);
        userDto.getRoles().add(role);
        userRepository.save(recommendationMapper.toUser(userDto));
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
