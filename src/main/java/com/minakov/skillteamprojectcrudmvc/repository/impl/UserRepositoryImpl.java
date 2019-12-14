package com.minakov.skillteamprojectcrudmvc.repository.impl;

import com.minakov.skillteamprojectcrudmvc.model.User;
import com.minakov.skillteamprojectcrudmvc.repository.UserRepository;
import com.minakov.skillteamprojectcrudmvc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Yaroslav Minakov
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Delete the user object
            User user = findById(id);
            if (user != null) {
                session.delete(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public User create(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Generate user id
            user.setId(UUID.randomUUID().toString());
            // Save the user object
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the user object
            session.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
