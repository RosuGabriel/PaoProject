package services.impl;

import jakarta.persistence.EntityManager;
import model.*;
import repositories.impl.CrewRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CrewService implements services.CrewService {
    private final CrewRepository repo = new CrewRepository();
    @Override
    public CrewMember create(Scanner scanner, EntityManager em) {
        System.out.println("(1)Create Actor    (2)Create Director    (0)Abort");
        var _option = scanner.nextInt();
        scanner.nextLine();
        switch (_option) {
            case (1):
                System.out.println("Enter title:");
                var name = scanner.nextLine();
                System.out.println("Enter birth year:");
                var year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter birth month:");
                var month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter birth day:");
                var day = scanner.nextInt();
                scanner.nextLine();
                Actor actor = new Actor(name, LocalDate.of(year, month, day));
                repo.addCrew(actor, em);
                return actor;
            case (2):
                System.out.println("Enter title:");
                name = scanner.nextLine();
                System.out.println("Enter birth year:");
                year = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter birth month:");
                month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter birth day:");
                day = scanner.nextInt();
                scanner.nextLine();
                Director director = new Director(name, LocalDate.of(year, month, day));
                repo.addCrew(director, em);
                return director;
            case (0):
                return null;
            default:
                System.out.println("Not an option! Crew member creation failed!");
                return null;
        }
    }

    @Override
    public List<CrewMember> getAll(EntityManager entityManager) {
        return null;
    }

    @Override
    public void delete(CrewMember crew, EntityManager entityManager) {

    }

    @Override
    public void update(Scanner scanner, EntityManager entityManager) {

    }


}
