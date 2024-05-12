package services;

import jakarta.persistence.EntityManager;
import model.AppUser;
import model.Item;
import model.Review;

import java.util.List;
import java.util.Scanner;

public interface ItemService {
    public Item create(Scanner scanner, EntityManager em);
    public void showReviews(Item item, Scanner scanner, EntityManager em);
    public Review addReview(AppUser user, Item item, Scanner scanner, EntityManager em);
    public void update(Item item, Scanner scanner, EntityManager em);
    public void showCrew(Item item, Scanner scanner, EntityManager em);
    public void delete(Item item, EntityManager em);
    public Item get(Scanner scanner, EntityManager em);
    public List<Item> getAll(EntityManager em);
    public List<Item> getAllContaining(Scanner scanner, EntityManager em);
}
