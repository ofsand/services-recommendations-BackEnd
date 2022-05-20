package org.capgemini.servicesrecommendationbackEnd.mapper;

import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDTO);
}
