package services.impl;

import jakarta.persistence.EntityManager;
import model.AppUser;
import repositories.impl.UserRepository;

import java.util.Scanner;

public class UserService implements services.UserService {
    UserRepository repo = new UserRepository();
    @Override
    public AppUser create(Scanner scanner, EntityManager em) {
        String username;

        while (true) {
            System.out.println("Enter username:");
            username = scanner.nextLine();
            if (em.find(AppUser.class, username) != null) {
                System.out.println("Alrady used username!");
            } else {
                break;
            }
        }

        System.out.println("Enter password:");
        var password = scanner.nextLine();

        var user = new AppUser(username, password);
        repo.create(user, em);

        return user;
    }

    @Override
    public void update(Scanner scanner, EntityManager em) {

    }

    @Override
    public void delete(Scanner scanner, EntityManager em) {

    }

    @Override // Login function
    public AppUser get(Scanner scanner, EntityManager em) {
        AppUser user = null;

        System.out.println("Enter username:");

        int attempts = 3;

        while (attempts > 0) {
            attempts--;

            var username = scanner.nextLine();
            user = repo.findByName(username, em);

            if (user == null & attempts > 0) {
                System.out.println("Enter a valid username:");
            }
            else {
                attempts = 0;
            }
        }

        attempts = 3;

        if (user != null) {

            System.out.println("Enter password:");

            while(attempts > 0) {
                attempts--;

                var password = scanner.nextLine();
                if (password.equals(user.getPassword())) {
                    System.out.println("Successfully logged as " + user.getName() + "!");
                    return user;
                }

                System.out.println("Incorrect password! Enter again:");
            }
        }

        System.out.println("Login failed!");

        return user;
    }
}
