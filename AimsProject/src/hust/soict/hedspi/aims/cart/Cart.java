package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(m.toString());
            }
        }
    }

    public void searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println(m.toString());
                return;
            }
        }
        System.out.println("No match found.");
    }
}