package repositories.impl;

import jakarta.persistence.EntityManager;
import model.AppUser;
import model.Item;
import model.Movie;
import model.Series;

import java.util.List;

public class ItemRepository implements repositories.ItemRepository  {
    @Override
    public void addItem(Item item, EntityManager em) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    @Override
    public void addMovie(Movie movie, EntityManager em) {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
    }

    @Override
    public void addSeries(Series series, EntityManager em) {
        em.getTransaction().begin();
        em.persist(series);
        em.getTransaction().commit();
    }

    @Override
    public void getReviews(Item item, EntityManager em) {
        em.createQuery("select i.reviews from Item i where i.id = :review_id");
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
