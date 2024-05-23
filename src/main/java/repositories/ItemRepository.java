package repositories;

import jakarta.persistence.EntityManager;
import model.*;

import java.util.List;

public interface ItemRepository {
    void addItem(Item item, EntityManager em);
    List<Review> getReviews(Item item, EntityManager em);
    List<CrewMember> getCrew(Item item, EntityManager em);

    List<Item> getAllItems(EntityManager em);
    Item getItemById(int id, EntityManager em);
    List<Item> getItemsContaining(String str, EntityManager em);

    void updateItem(Item item, EntityManager em);
    void deleteItem(int id, EntityManager em);
}
