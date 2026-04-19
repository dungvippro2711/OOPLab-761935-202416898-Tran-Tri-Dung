package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Batman", "Action", 15f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Superman", "Action", 18f);

        cart.addMedia(dvd1, dvd2);

        cart.print();

        cart.searchByTitle("man");
        cart.searchById(dvd1.getId());
    }
}