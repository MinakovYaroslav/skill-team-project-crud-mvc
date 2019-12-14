package com.minakov.skillteamprojectcrudmvc.service.impl;

import com.minakov.skillteamprojectcrudmvc.model.Skill;
import com.minakov.skillteamprojectcrudmvc.repository.SkillRepository;
import com.minakov.skillteamprojectcrudmvc.repository.impl.SkillRepositoryImpl;
import com.minakov.skillteamprojectcrudmvc.service.SkillService;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;

    public SkillServiceImpl() {
        this.skillRepository = new SkillRepositoryImpl();
    }

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public void delete(String id) {
        skillRepository.delete(id);
    }

    @Override
    public Skill findById(String id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.create(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }
}
