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
@Table(name = "customers")
public class Customer extends AbstractIdentifiable {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name="customer_projects",
            joinColumns=@JoinColumn(name="customer_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="project_id", referencedColumnName="id"))
    private Set<Project> projects;
}
