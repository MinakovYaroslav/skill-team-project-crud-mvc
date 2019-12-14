package com.minakov.skillteamprojectcrudmvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Yaroslav Minakov
 */
@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team extends AbstractIdentifiable {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="team_users",
            joinColumns=@JoinColumn(name="team_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
    private Set<User> users;
}
