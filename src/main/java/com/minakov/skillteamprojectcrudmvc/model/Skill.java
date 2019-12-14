package com.minakov.skillteamprojectcrudmvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Yaroslav Minakov
 */
@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill extends AbstractIdentifiable {

    @Column(name = "name")
    private String name;
}
