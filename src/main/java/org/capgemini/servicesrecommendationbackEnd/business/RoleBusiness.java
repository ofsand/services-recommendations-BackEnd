package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.Role;

public interface RoleBusiness {
    Role add(Role role);
    Role findById(Long id);
}
