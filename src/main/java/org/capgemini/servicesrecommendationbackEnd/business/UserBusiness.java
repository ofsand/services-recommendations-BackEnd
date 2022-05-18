package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.models.User;

import java.util.List;


public interface UserBusiness {

    public User save(User user);

    public List<User> findAllUsers();
}
