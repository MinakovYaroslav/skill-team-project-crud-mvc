package com.minakov.skillteamprojectcrudmvc.service.impl;

import com.minakov.skillteamprojectcrudmvc.model.Project;
import com.minakov.skillteamprojectcrudmvc.repository.ProjectRepository;
import com.minakov.skillteamprojectcrudmvc.repository.impl.ProjectRepositoryImpl;
import com.minakov.skillteamprojectcrudmvc.service.ProjectService;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl() {
        this.projectRepository = new ProjectRepositoryImpl();
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void delete(String id) {
        projectRepository.delete(id);
    }

    @Override
    public Project findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project create(Project project) {
        return projectRepository.create(project);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.update(project);
    }
}
