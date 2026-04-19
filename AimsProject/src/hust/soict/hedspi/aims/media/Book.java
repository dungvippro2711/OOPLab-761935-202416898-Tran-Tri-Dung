package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    // Constructor mặc định (như trong ảnh mẫu)
    public Book() {
        super("");
    }

    // Constructor tiện dụng để khởi tạo nhanh
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    // Getter cho authors
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // Phương thức thêm tác giả (kiểm tra xem đã tồn tại chưa)
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added to book: " + getTitle());
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    // Phương thức xóa tác giả (kiểm tra xem có trong danh sách không)
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed from book: " + getTitle());
        } else {
            System.out.println("Author '" + authorName + "' not found in the list.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + ": " + getCost() + " $";
    }
}