package hust.soict.hedspi.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }
    public int getId() { return id; }
}