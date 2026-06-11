package hust.soict.hedspi.aims;

import java.util.Collections;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup();
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        store.print();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaFromStore();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    private static void seeMediaDetails() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            System.out.println(media.toString());
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        try {
                            cart.addMedia(media);
                        } catch (hust.soict.hedspi.aims.exception.LimitExceededException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    private static void addMediaToCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            try {
                cart.addMedia(media);
                System.out.println("Current items in cart: " + cart.getCount());
            } catch (hust.soict.hedspi.aims.exception.LimitExceededException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMediaFromStore() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add Media");
        System.out.println("2. Remove Media");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Choose type: 1. DVD, 2. CD, 3. Book");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Cost: ");
            float cost = scanner.nextFloat();
            if (type == 1) store.addMedia(new DigitalVideoDisc(title, category, cost));
            else if (type == 2) store.addMedia(new CompactDisc(title, category, null, 0, cost, null));
            else store.addMedia(new Book(title, category, cost));
        } else {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.search(title);
            if (m != null) store.removeMedia(m);
        }
    }

    public static void viewCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    System.out.println("Order created.");
                    cart.clear();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void filterCart() {
        System.out.println("1. Filter by ID, 2. Filter by Title");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.print("Enter ID: ");
            cart.searchById(scanner.nextInt());
        } else {
            System.out.print("Enter Title: ");
            cart.searchByTitle(scanner.nextLine());
        }
    }

    private static void sortCart() {
        System.out.println("1. Sort by Title, 2. Sort by Cost");
        int option = scanner.nextInt();
        if (option == 1) cart.sortByTitle();
        else cart.sortByCost();
        cart.print();
    }

    private static void removeFromCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = cart.search(title);
        if (m != null) cart.removeMedia(m);
    }

    private static void playMediaFromCart() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        Media m = cart.search(title);
        if (m instanceof Playable) ((Playable) m).play();
    }

    private static void initSetup() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new Book("Java Programming", "Education", 15.5f));
    }
}