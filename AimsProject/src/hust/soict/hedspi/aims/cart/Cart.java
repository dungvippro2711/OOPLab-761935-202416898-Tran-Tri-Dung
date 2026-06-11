package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public int getCount() {
        return itemsOrdered.size();
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public Media search(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
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

    public void searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                System.out.println(m.toString());
            }
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void print() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}