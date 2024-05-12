import jakarta.persistence.Persistence;

import services.impl.Menu;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("PaoProject");
        var entityManager = entityManagerFactory.createEntityManager();

        var scanner = new Scanner(System.in);
        var menu = Menu.getMenu();

        menu.run(scanner, entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }
}

