package com.minakov.skillteamprojectcrudmvc.service.impl;

import com.minakov.skillteamprojectcrudmvc.model.Team;
import com.minakov.skillteamprojectcrudmvc.repository.TeamRepository;
import com.minakov.skillteamprojectcrudmvc.repository.impl.TeamRepositoryImpl;
import com.minakov.skillteamprojectcrudmvc.service.TeamService;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl() {
        this.teamRepository = new TeamRepositoryImpl();
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public void delete(String id) {
        teamRepository.delete(id);
    }

    @Override
    public Team findById(String id) {
        return teamRepository.findById(id);
    }

    @Override
    public Team create(Team team) {
        return teamRepository.create(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.update(team);
    }
}
