package services.impl;

import jakarta.persistence.EntityManager;
import model.AppUser;
import services.MenuService;

import java.util.Scanner;

public class Menu implements MenuService {
    public static Menu getMenu() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    private Menu() {

    }



    protected void showAll(EntityManager entityManager) {
        var items = itemService.getAll(entityManager);
        for(var item : items) {
            item.show();
        }
    }

    protected void selectItem(Scanner scanner, EntityManager entityManager) {
        var item = itemService.get(scanner, entityManager);

        if (item == null) {
            System.out.println("No item with this id!");
            return;
        }

        while(true) {
            System.out.println("(1)Show brief    (2)Show crew    (3)Show reviews    (4)Add review    (5)Edit item    (6)Delete item    (0)Exit");

            var _option = scanner.nextInt();
            scanner.nextLine();
            switch (_option){
                case 1:
                    item.show();
                    break;
                case 2:
                    itemService.showCrew(item, scanner, entityManager);
                    break;
                case 3:
                    itemService.showReviews(item, scanner, entityManager);
                    break;
                case 4:
                    itemService.addReview(user, item, scanner, entityManager);
                    break;
                case 5:
                    itemService.update(item, scanner, entityManager);
                    break;
                case 6:
                    itemService.delete(item, entityManager);
                    return;
                case 0:
                    return;
            }
        }
    }

    protected void search(Scanner scanner, EntityManager entityManager) {
        var items = itemService.getAllContaining(scanner, entityManager);
        if(items.isEmpty()) {
            System.out.println("No item found!");
            return;
        }
        for (var item : items) {
            item.show();
        }
    }

    protected void addItem(Scanner scanner, EntityManager entityManager) {
        itemService.create(scanner, entityManager);
    }

    protected void logIn(Scanner scanner, EntityManager entityManager) {
        user = userService.get(scanner, entityManager);
    }

    protected void logOut() {
        user = null;
    }

    protected void register(Scanner scanner, EntityManager entityManager) {
        user = userService.create(scanner, entityManager);
    }

    private void crewMenu(Scanner scanner, EntityManager entityManager) {
        if (user != null) {
            while (true) {
                System.out.println("(1)Show crew    (2)Edit crew    (3)Search crew    (4)Add crew    (0)Exit");
                var _option = scanner.nextInt();
                scanner.nextLine();

                switch (_option) {
                    case 1:
                        var crew = crewService.getAll(entityManager);
                        for (var member : crew) {
                            member.show();
                        }
                        break;
                    case 2:
                        crewService.update(scanner, entityManager);
                        break;
                    case 3:
                        crew = crewService.getAllContaining(scanner, entityManager);
                        if(crew.isEmpty()) {
                            System.out.println("No crew member found!");
                            break;
                        }
                        for (var member : crew) {
                            member.show();
                        }
                        break;
                    case 4:
                        crewService.create(scanner, entityManager);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Not an option!");
                        break;
                }
            }
        }
        else {
            while (true) {
                System.out.println("(1)Show crew    (2)Search crew    (0)Exit");
                var _option = scanner.nextInt();
                scanner.nextLine();

                switch (_option) {
                    case 1:
                        var crew = crewService.getAll(entityManager);
                        for (var member : crew) {
                            member.show();
                        }
                        break;
                    case 2:
                        crew = crewService.getAllContaining(scanner, entityManager);
                        if(crew.isEmpty()) {
                            System.out.println("No crew member found!");
                            break;
                        }
                        for (var member : crew) {
                            member.show();
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Not an option!");
                        break;
                }
            }
        }
    }



    @Override
    public void run(Scanner scanner, EntityManager entityManager) {
        while(true) {
            System.out.println("Choose an action:");
            int _option;

            if (user != null) {
                System.out.println("(1)Show items    (2)Select item    (3)Search item    (4)Add item    (5)Crew    (6)Log out    (0)Exit");
                _option = scanner.nextInt();
                scanner.nextLine();

                switch (_option) {
                    case 1:
                        showAll(entityManager);
                        break;
                    case 2:
                        selectItem(scanner, entityManager);
                        break;
                    case 3:
                        search(scanner, entityManager);
                        break;
                    case 4:
                        addItem(scanner, entityManager);
                        break;
                    case 5:
                        crewMenu(scanner, entityManager);
                        break;
                    case 6:
                        logOut();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("This is not an option!");
                }
            } else {
                System.out.println("(1)Show items    (2)Select item    (3)Search item    (4)Crew    (5)Register    (6)Log in    (0)Exit");
                _option = scanner.nextInt();
                scanner.nextLine();
                switch (_option) {
                    case 1:
                        showAll(entityManager);
                        break;
                    case 2:
                        selectItem(scanner, entityManager);
                        break;
                    case 3:
                        search(scanner, entityManager);
                        break;
                    case 4:
                        crewMenu(scanner, entityManager);
                        break;
                    case 5:
                        register(scanner, entityManager);
                        break;
                    case 6:
                        logIn(scanner, entityManager);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("This is not an option!");
                        break;
                }
            }
        }
    }



    private static Menu instance;
    private AppUser user = null;

    private final CrewService crewService = new CrewService();
    private final ItemService itemService = new ItemService();
    private final UserService userService = new UserService();
}
