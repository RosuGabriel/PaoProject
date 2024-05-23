package repositories.impl;

import jakarta.persistence.EntityManager;
import model.Actor;
import model.CrewMember;
import model.Director;
import model.Item;

import java.util.List;

public class CrewRepository implements repositories.CrewRepository {
    @Override
    public void addCrew(CrewMember crew, EntityManager em) {
        em.getTransaction().begin();
        em.persist(crew);
        em.getTransaction().commit();
    }

    @Override
    public void addActor(Actor actor, EntityManager em) {
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
    }

    @Override
    public void addDirector(Director director, EntityManager em) {
        em.getTransaction().begin();
        em.persist(director);
        em.getTransaction().commit();
    }

    @Override
    public List<CrewMember> getAllCrew(EntityManager em) {
        return em.createQuery("select c from CrewMember c", CrewMember.class).getResultList();
    }

    @Override
    public CrewMember getCrewById(int id, EntityManager em) {
        return em.find(CrewMember.class, id);
    }

    @Override
    public void updateCrew(CrewMember crew, EntityManager em) {
        em.getTransaction().begin();
        em.merge(crew);
        em.getTransaction().commit();
    }

    @Override
    public void deleteCrew(int id, EntityManager em) {
        em.getTransaction().begin();
        em.remove(em.find(CrewMember.class, id));
        em.getTransaction().commit();
    }

    @Override
    public List<CrewMember> getCrewContaining(String str, EntityManager entityManager) {
        var query =  entityManager.createQuery("select c from CrewMember c where lower(c.name) like :substring", CrewMember.class);
        query.setParameter("substring", "%"+ str.toLowerCase() +"%");
        return query.getResultList();
    }
}
