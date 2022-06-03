package org.capgemini.servicesrecommendationbackEnd.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.exceptions.BusinessException;
import org.capgemini.servicesrecommendationbackEnd.exceptions.ErrorsMessage;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;
import org.capgemini.servicesrecommendationbackEnd.repositories.RoleRepository;
import org.capgemini.servicesrecommendationbackEnd.services.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorsMessage.NOT_FOUND_ID));
    }
}
