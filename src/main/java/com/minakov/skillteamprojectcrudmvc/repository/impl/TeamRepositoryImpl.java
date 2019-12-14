package com.minakov.skillteamprojectcrudmvc.repository.impl;

import com.minakov.skillteamprojectcrudmvc.model.Team;
import com.minakov.skillteamprojectcrudmvc.repository.TeamRepository;
import com.minakov.skillteamprojectcrudmvc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Yaroslav Minakov
 */
public class TeamRepositoryImpl implements TeamRepository {

    @Override
    public List<Team> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Team", Team.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Delete the team object
            Team team = findById(id);
            if (team != null) {
                session.delete(team);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Team.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Team create(Team team) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Generate team id
            team.setId(UUID.randomUUID().toString());
            // Save the team object
            session.save(team);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    @Transactional
    public Team update(Team team) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the team object
            session.update(team);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return team;
    }
}
