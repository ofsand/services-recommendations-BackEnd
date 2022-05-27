package org.capgemini.servicesrecommendationbackEnd.models.dto;

import lombok.Data;
import org.capgemini.servicesrecommendationbackEnd.models.entities.Role;

import java.util.List;

@Data
public class UserDto {
    private Long idUser;
    private String email;
    private String pseudo;
    private String username;
    private String password;
    private List<Role> roles;
}
