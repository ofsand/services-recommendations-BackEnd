package org.capgemini.servicesrecommendationbackEnd.dto;

import lombok.Data;
import org.capgemini.servicesrecommendationbackEnd.models.Role;

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
