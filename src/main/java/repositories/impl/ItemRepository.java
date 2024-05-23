package repositories.impl;

import jakarta.persistence.EntityManager;
import model.*;

import java.util.List;

public class ItemRepository implements repositories.ItemRepository  {
    @Override
    public void addItem(Item item, EntityManager em) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    @Override
    public List<Review> getReviews(Item item, EntityManager em) {
        return em.createQuery("select i.reviews from Item i where i.id = :review_id", Review.class).getResultList();
    }

    @Override
    public List<CrewMember> getCrew(Item item, EntityManager em) {
        return em.createQuery("select i.crew from Item i where i.id = :crew_id", CrewMember.class).getResultList();
    }

    @Override
    public List<Item> getAllItems(EntityManager em) {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    @Override
    public Item getItemById(int id, EntityManager em) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> getItemsContaining(String str, EntityManager em) {
        var query =  em.createQuery("select i from Item i where lower(i.title) like :substring", Item.class);
        query.setParameter("substring", "%"+ str.toLowerCase() +"%");
        return query.getResultList();
    }

    @Override
    public void updateItem(Item item, EntityManager em) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    @Override
    public void deleteItem(int id, EntityManager em) {
        em.getTransaction().begin();
        em.remove(em.find(Item.class, id));
        em.getTransaction().commit();
    }
}
