package com.minakov.skillteamprojectcrudmvc.service.impl;

import com.minakov.skillteamprojectcrudmvc.model.Customer;
import com.minakov.skillteamprojectcrudmvc.repository.CustomerRepository;
import com.minakov.skillteamprojectcrudmvc.repository.impl.CustomerRepositoryimpl;
import com.minakov.skillteamprojectcrudmvc.service.CustomerService;

import java.util.List;

/**
 * @author Yaroslav Minakov
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerRepositoryimpl();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(String id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.update(customer);
    }
}
