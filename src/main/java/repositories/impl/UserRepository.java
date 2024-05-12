package repositories.impl;

import jakarta.persistence.EntityManager;
import model.AppUser;

import java.util.List;

public class UserRepository implements repositories.UserRepository {
    @Override
    public void create(AppUser user, EntityManager em) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public AppUser findByName(String username, EntityManager em) {
        return em.find(AppUser.class, username);
    }

    @Override
    public List<AppUser> allUsers(EntityManager em) {
        return em.createQuery("select c from AppUser c", AppUser.class).getResultList();
    }

    @Override
    public void delete(int id, EntityManager em) {
        var user = em.find(AppUser.class, id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(AppUser user, EntityManager em) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
}
