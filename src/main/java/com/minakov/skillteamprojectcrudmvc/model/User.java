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
@Table(name = "users")
public class User extends AbstractIdentifiable {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_skills",
            joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="skill_id", referencedColumnName="id"))
    private Set<Skill> skills;
}
