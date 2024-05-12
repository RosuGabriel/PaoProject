package services;

import jakarta.persistence.EntityManager;
import model.AppUser;

import java.util.Scanner;

public interface UserService {
    public AppUser create(Scanner scanner, EntityManager em);
    public void update(Scanner scanner, EntityManager em);
    public void delete(Scanner scanner, EntityManager em);
    public AppUser get(Scanner scanner, EntityManager em);
}
