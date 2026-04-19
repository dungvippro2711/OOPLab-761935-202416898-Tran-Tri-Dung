package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists!");
        } else {
            tracks.add(track);
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle() + " by " + artist);
            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
        }
    }
}