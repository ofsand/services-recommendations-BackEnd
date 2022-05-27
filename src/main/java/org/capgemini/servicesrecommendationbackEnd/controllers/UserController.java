package org.capgemini.servicesrecommendationbackEnd.controllers;

import lombok.RequiredArgsConstructor;
import org.capgemini.servicesrecommendationbackEnd.services.serviceInterface.AdminServiceInterface;
import org.capgemini.servicesrecommendationbackEnd.services.serviceImpl.UserServiceImpl;
import org.capgemini.servicesrecommendationbackEnd.models.dto.UserDto;
import org.capgemini.servicesrecommendationbackEnd.models.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final AdminServiceInterface adminBusiness;
    private final UserServiceImpl userBusinessDefault;

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
