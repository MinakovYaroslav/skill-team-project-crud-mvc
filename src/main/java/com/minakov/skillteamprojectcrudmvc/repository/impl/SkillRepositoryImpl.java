package com.minakov.skillteamprojectcrudmvc.repository.impl;

import com.minakov.skillteamprojectcrudmvc.model.Skill;
import com.minakov.skillteamprojectcrudmvc.repository.SkillRepository;
import com.minakov.skillteamprojectcrudmvc.util.HibernateUtil;
import org.hibernate.Session;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author Yaroslav Minakov
 */
public class SkillRepositoryImpl implements SkillRepository {

    @Override
    public List<Skill> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Skill", Skill.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Delete the skill object
            Skill skill = findById(id);
            if (skill != null) {
                session.delete(skill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Skill.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public Skill create(Skill skill) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Generate skill id
            skill.setId(UUID.randomUUID().toString());
            // Save the skill object
            session.save(skill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    @Transactional
    public Skill update(Skill skill) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Update the skill object
            session.update(skill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return skill;
    }
}
