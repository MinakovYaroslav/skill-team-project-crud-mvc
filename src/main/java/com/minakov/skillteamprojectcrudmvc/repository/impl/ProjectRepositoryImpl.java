package com.minakov.skillteamprojectcrudmvc.repository.impl;

import com.minakov.skillteamprojectcrudmvc.model.Project;
import com.minakov.skillteamprojectcrudmvc.repository.ProjectRepository;
import com.minakov.skillteamprojectcrudmvc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Yaroslav Minakov
 */
public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public List<Project> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Project", Project.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Delete the project object
            Project project = findById(id);
            if (project != null) {
                session.delete(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Project.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Project create(Project project) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Generate project id
            project.setId(UUID.randomUUID().toString());
            // Save the project object
            session.save(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    @Transactional
    public Project update(Project project) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the project object
            session.update(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project;
    }
}
