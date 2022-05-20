package org.capgemini.servicesrecommendationbackEnd.repository;

import org.capgemini.servicesrecommendationbackEnd.models.Role;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
