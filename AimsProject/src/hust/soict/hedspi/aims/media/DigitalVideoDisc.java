package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, null, 0, cost);
    }
    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0.0f);
    }
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.err.println("ERROR: DVD length is non-positive! Cannot play: " + this.getTitle());
        }
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + 
               (getCategory() != null ? getCategory() : "N/A") + " - " + 
               (getDirector() != null ? getDirector() : "N/A") + " - " + 
               getLength() + ": " + getCost() + " $";
    }
    public boolean isMatch(String title) {
        if (this.getTitle() == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
}