package com.minakov.skillteamprojectcrudmvc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Yaroslav Minakov
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractIdentifiable {

    @Id
    private String id;
}
