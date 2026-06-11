package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title, String category, float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("ERROR: Cost cannot be negative!");
        }
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        try {
            Media media = (Media) o;
            boolean titleEquals = (this.title != null) && this.title.equalsIgnoreCase(media.getTitle());
            boolean costEquals = (Float.compare(this.cost, media.getCost()) == 0);
            return titleEquals && costEquals;
        } catch (NullPointerException | ClassCastException e) {
            return false;
        }
    }

    @Override
    public int compareTo(Media other) {
        try {
            int titleComparison = this.title.compareToIgnoreCase(other.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            } else {
                return Float.compare(this.cost, other.getCost());
            }
        } catch (NullPointerException e) {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Media [ID=" + id + ", Title=" + title + ", Category=" + category + ", Cost=" + cost + "$]";
    }
}