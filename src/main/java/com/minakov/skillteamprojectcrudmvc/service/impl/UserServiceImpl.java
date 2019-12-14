package com.minakov.skillteamprojectcrudmvc.service.impl;

import com.minakov.skillteamprojectcrudmvc.model.User;
import com.minakov.skillteamprojectcrudmvc.repository.UserRepository;
import com.minakov.skillteamprojectcrudmvc.repository.impl.UserRepositoryImpl;
import com.minakov.skillteamprojectcrudmvc.service.UserService;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }
}
