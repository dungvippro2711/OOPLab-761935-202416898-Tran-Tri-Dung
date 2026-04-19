package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.*;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        
        CompactDisc cd = new CompactDisc("Star Wars", "Sci-Fi", "George Lucas", 120, 25.0f, "John Williams");
        
        Book book = new Book("Java Programming", "Education", 15.5f);
        book.addAuthor("James Gosling");

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}