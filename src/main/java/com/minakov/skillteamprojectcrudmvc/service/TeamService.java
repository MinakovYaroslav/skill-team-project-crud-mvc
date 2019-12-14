package com.minakov.skillteamprojectcrudmvc.service;

import com.minakov.skillteamprojectcrudmvc.model.Team;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface TeamService {

    List<Team> findAll();

    void delete(String id);

    Team findById(String id);

    Team create(Team team);

    Team update(Team team);
}
