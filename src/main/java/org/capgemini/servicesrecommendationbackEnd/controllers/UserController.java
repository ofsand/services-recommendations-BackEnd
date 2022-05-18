package org.capgemini.servicesrecommendationbackEnd.controllers;

import org.capgemini.servicesrecommendationbackEnd.business.UserBusiness;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public User save(@RequestBody User user){
        return userBusiness.save(user);
    };

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> findAllUsers(){
        return userBusiness.findAllUsers();
    };
}
