package com.minakov.skillteamprojectcrudmvc.service;

import com.minakov.skillteamprojectcrudmvc.model.User;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface UserService {

    List<User> findAll();

    void delete(String id);

    User findById(String id);

    User create(User user);

    User update(User user);
}
