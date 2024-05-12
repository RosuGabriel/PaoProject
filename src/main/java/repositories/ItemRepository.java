package repositories;

import jakarta.persistence.EntityManager;
import model.Item;
import model.Movie;
import model.Series;

import java.util.List;

public interface ItemRepository {
    void addItem(Item item, EntityManager em);
    void addMovie(Movie movie, EntityManager em);
    void addSeries(Series series, EntityManager em);
    void getReviews(Item item, EntityManager em);
    List<Item> getAllItems(EntityManager em);
    Item getItemById(int id, EntityManager em);
    void updateItem(Item item, EntityManager em);
    void deleteItem(int id, EntityManager em);
}
