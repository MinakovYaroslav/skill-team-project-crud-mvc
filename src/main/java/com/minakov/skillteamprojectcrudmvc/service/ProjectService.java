package com.minakov.skillteamprojectcrudmvc.service;

import com.minakov.skillteamprojectcrudmvc.model.Project;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface ProjectService {

    List<Project> findAll();

    void delete(String id);

    Project findById(String id);

    Project create(Project project);

    Project update(Project project);
}
