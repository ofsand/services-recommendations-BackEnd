package org.capgemini.servicesrecommendationbackEnd.business;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.UserMapper;
import org.capgemini.servicesrecommendationbackEnd.models.Recommendation;
import org.capgemini.servicesrecommendationbackEnd.models.Role;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.capgemini.servicesrecommendationbackEnd.repository.RecommendationRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.RoleRepository;
import org.capgemini.servicesrecommendationbackEnd.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor @Slf4j
@Service
public class UserBusinessDefault implements UserBusiness, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final ServiceTradesPersonBusiness serviceTradesPersonBusiness;
    private final RecommendationRepository recommendationRepository;
    private final PasswordEncoder passwordEncoder;


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
        Collection<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRolesTemp()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }
    @Override
    public UserDto addUser(User user) {
        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDto findUserById(Long userId) {
        return userMapper.userToUserDto(userRepository.getById(userId));
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
