package com.minakov.skillteamprojectcrudmvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Yaroslav Minakov
 */
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project extends AbstractIdentifiable {

    @Column(name = "name")
    private String name;

    @Column(name = "budget")
    private BigDecimal budget;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="project_teams",
            joinColumns=@JoinColumn(name="project_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="team_id", referencedColumnName="id"))
    private Set<Team> teams;
}
