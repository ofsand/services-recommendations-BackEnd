package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.business.AdminBusiness;
import org.capgemini.servicesrecommendationbackEnd.business.UserBusinessDefault;
import org.capgemini.servicesrecommendationbackEnd.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.mapper.UserMapper;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final AdminBusiness adminBusiness;
    private final UserBusinessDefault userBusinessDefault;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> findAll() {
        return  adminBusiness.getAll();
    }
    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userBusinessDefault.saveUser(user));
    }
}
