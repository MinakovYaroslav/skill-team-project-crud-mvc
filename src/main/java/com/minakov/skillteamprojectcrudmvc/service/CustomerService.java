package com.minakov.skillteamprojectcrudmvc.service;

import com.minakov.skillteamprojectcrudmvc.model.Customer;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public interface CustomerService {

    List<Customer> findAll();

    void delete(String id);

    Customer findById(String id);

    Customer create(Customer customer);

    Customer update(Customer customer);
}
