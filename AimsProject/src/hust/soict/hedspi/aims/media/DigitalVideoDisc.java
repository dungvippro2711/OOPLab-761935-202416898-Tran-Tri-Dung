package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}