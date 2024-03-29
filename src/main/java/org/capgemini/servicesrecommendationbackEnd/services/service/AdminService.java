package org.capgemini.servicesrecommendationbackEnd.services.service;

import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;

import java.util.List;

public interface AdminService {
    List<UserDto> getAll();
    UserDto add(User user);
}