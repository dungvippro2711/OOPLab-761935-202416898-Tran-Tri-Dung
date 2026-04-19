package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public int getLength() { return length; }
    public String getDirector() { return director; }
}