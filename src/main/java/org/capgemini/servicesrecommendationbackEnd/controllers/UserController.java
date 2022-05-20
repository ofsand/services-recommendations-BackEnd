package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.AdminBusiness;
import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final AdminBusiness adminBusiness;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> findAll() {
        return  adminBusiness.getAll();
    }
}
