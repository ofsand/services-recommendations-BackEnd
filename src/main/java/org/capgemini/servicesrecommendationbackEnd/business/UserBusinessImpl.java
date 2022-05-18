package org.capgemini.servicesrecommendationbackEnd.business;

import org.capgemini.servicesrecommendationbackEnd.dao.UserDao;
import org.capgemini.servicesrecommendationbackEnd.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessImpl implements UserBusiness{

    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

}
