package com.minakov.skillteamprojectcrudmvc.repository.impl;

import com.minakov.skillteamprojectcrudmvc.model.Customer;
import com.minakov.skillteamprojectcrudmvc.repository.CustomerRepository;
import com.minakov.skillteamprojectcrudmvc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Yaroslav Minakov
 */
public class CustomerRepositoryimpl implements CustomerRepository {

    @Override
    public List<Customer> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Delete the customer object
            Customer customer = findById(id);
            if (customer != null) {
                session.delete(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Generate customer id
            customer.setId(UUID.randomUUID().toString());
            // Save the customer object
            session.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    @Transactional
    public Customer update(Customer customer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the customer object
            session.update(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
}
