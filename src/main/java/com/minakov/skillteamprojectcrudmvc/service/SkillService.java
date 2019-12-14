package com.minakov.skillteamprojectcrudmvc.service;

import com.minakov.skillteamprojectcrudmvc.model.Skill;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface SkillService {

    List<Skill> findAll();

    void delete(String id);

    Skill findById(String id);

    Skill create(Skill skill);

    Skill update(Skill skill);
}
