package services.impl;

import jakarta.persistence.EntityManager;
import model.*;
import repositories.impl.CrewRepository;
import repositories.impl.ItemRepository;
import repositories.impl.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ItemService implements services.ItemService {
    ItemRepository repo = new ItemRepository();
    @Override
    public Item create(Scanner scanner, EntityManager em) {
        System.out.println("(1)Create Movie    (2)Create Series    (0)Abort");
        var _option = scanner.nextInt();
        scanner.nextLine();
        switch (_option) {
            case(1):
                System.out.println("Enter title:");
                var title = scanner.nextLine();
                System.out.println("Enter release year:");
                var year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release month:");
                var month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release day:");
                var day = scanner.nextInt();
                scanner.nextLine();
                Movie movie = new Movie(title, LocalDate.of(year, month, day));
                repo.addItem(movie, em);
                return movie;
            case(2):
                System.out.println("Enter title:");
                title = scanner.nextLine();
                System.out.println("Enter release year:");
                year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release month:");
                month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release day:");
                day = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter number of seasons:");
                var seasons = scanner.nextInt();
                scanner.nextLine();
                Series series = new Series(title, LocalDate.of(year, month, day));
                series.setSeasons(seasons);
                repo.addItem(series, em);
                return series;
            case(0):
                return null;
            default:
                System.out.println("Not an option! Item creation failed!");
                return null;
        }
    }

    @Override
    public void showReviews(Item item, Scanner scanner, EntityManager em) {
        var reviews = item.getReviews();
        if (reviews != null) {
            for (var review : reviews) {
                review.show();
            }
        }
        else {
            System.out.println("0 reviews!");
        }
    }

    @Override
    public Review addReview(AppUser user, Item item, Scanner scanner, EntityManager em) {
        if (user == null) {
            System.out.println("You are not logged!");
            return null;
        }

        var review = new Review(user, item);

        System.out.println("Rate item (1-10):");
        review.setRating(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Want to write something about it? (y/n):");
        if (scanner.next().equals("y")) {
            scanner.nextLine();
            System.out.println("Go for it:");
            review.setText(scanner.nextLine());
        }

        item.addReview(review);
        repo.updateItem(item, em);

        var userRepo = new UserRepository();
        user.addReview(review);

        return review;
    }

    @Override
    public void update(Item item, Scanner scanner, EntityManager em) {
        System.out.println("(1)Edit title    (2)Edit release date    (3)Add Crew    (0)Abort");
        var _option = scanner.nextInt();
        scanner.nextLine();
        switch (_option) {
            case 1:
                System.out.println("Enter title:");
                item.setTitle(scanner.nextLine());
                repo.updateItem(item, em);
                break;
            case 2:
                System.out.println("Enter release year:");
                var year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release month:");
                var month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter release day:");
                var day = scanner.nextInt();
                scanner.nextLine();
                item.setReleaseDate(LocalDate.of(year, month, day));
                repo.updateItem(item, em);
                break;
            case 3:
                CrewRepository crewRepo = new CrewRepository();
                System.out.println("Enter crew id:");
                var id = scanner.nextInt();
                CrewMember crew = crewRepo.getCrewById(id, em);
                if (crew == null) {
                    System.out.println("A crew member with this id doesn't exist!");
                    return;
                }
                item.addCrew(crew);
                repo.updateItem(item, em);
                System.out.println("Successfully added " + crew.getName() + "!");
                break;
            case 0:
                return;
            default:
                System.out.println("Not an option!");
                break;
        }
    }

    @Override
    public void showCrew(Item item, Scanner scanner, EntityManager em) {
        var crew = item.getCrew();
        if (crew != null) {
            for (var member : crew) {
                member.show();
            }
        }
        else {
            System.out.println("0 crew members!");
        }
    }

    @Override
    public void delete(Item item, EntityManager em) {
        repo.deleteItem(item.getId(), em);
    }

    @Override
    public Item get(Scanner scanner, EntityManager em) {
        System.out.println("Enter id of wanted item:");
        var id = scanner.nextInt();
        scanner.nextLine();
        var item = repo.getItemById(id, em);
        return item;
    }

    @Override
    public List<Item> getAll(EntityManager em) {
        return repo.getAllItems(em);
    }

    @Override
    public List<Item> getAllContaining(Scanner scanner, EntityManager em) {
        System.out.println("Enter title:");
        var str = scanner.nextLine();
        return repo.getItemsContaining(str, em);
    }
}
