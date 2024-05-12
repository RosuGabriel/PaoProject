package services;

import jakarta.persistence.EntityManager;

import java.util.Scanner;

public interface MenuService {
    public void run(Scanner scanner, EntityManager entityManager);
}
