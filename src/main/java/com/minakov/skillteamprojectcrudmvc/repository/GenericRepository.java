package com.minakov.skillteamprojectcrudmvc.repository;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface GenericRepository<E, ID> {

    List<E> findAll();

    void delete(ID id);

    E findById(ID id);

    E create(E e);

    E update(E e);
}
