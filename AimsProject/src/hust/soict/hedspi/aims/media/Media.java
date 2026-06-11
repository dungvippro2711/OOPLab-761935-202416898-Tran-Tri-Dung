package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
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
        if (o == null || !(o instanceof Media)) return false;
        Media media = (Media) o;
        try {
            return title != null && title.equalsIgnoreCase(media.getTitle());
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Media [ID=" + id + ", Title=" + title + ", Category=" + category + ", Cost=" + cost + "$]";
    }
}