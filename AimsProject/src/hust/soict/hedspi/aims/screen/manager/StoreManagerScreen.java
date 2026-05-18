package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel centerPanel; // lưu lại panel chứa các media để refresh

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER); // createCenter trả về JScrollPane

        setTitle("Store Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> refreshCenter());
        menu.add(viewStore);

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookToStoreScreen(store, this));
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCompactDiscToStoreScreen(store, this));
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store, this));
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    // Tạo panel chứa các media với GridLayout 3 cột, số hàng tự động
    private JPanel createGridPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10)); // 0 hàng, 3 cột
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ArrayList<Media> items = store.getItemsInStore();
        for (Media media : items) {
            panel.add(new MediaStore(media));
        }
        // Nếu muốn luôn có đủ 3x3 ô (kể cả trống), có thể thêm panel rỗng đến khi đủ 9
        // Nhưng yêu cầu "dạng 3x3" có thể chỉ là cố định 3 cột, không nhất thiết phải đủ 9 ô.
        // Tôi để tự động, nếu ít hơn 9 thì các ô trống không hiển thị – vẫn giữ cấu trúc 3 cột.
        return panel;
    }

    // Tạo JScrollPane chứa gridPanel
    private JScrollPane createCenter() {
        centerPanel = createGridPanel();
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    // Làm mới vùng trung tâm khi thêm/xóa media
    public void refreshCenter() {
        // Tạo panel mới
        JPanel newGridPanel = createGridPanel();
        // Thay thế bên trong JScrollPane cũ
        Container cp = getContentPane();
        Component oldScrollPane = ((BorderLayout) cp.getLayout()).getLayoutComponent(BorderLayout.CENTER);
        if (oldScrollPane instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) oldScrollPane;
            scrollPane.setViewportView(newGridPanel);
            centerPanel = newGridPanel;
        } else {
            // Trường hợp chưa có, thêm mới
            cp.add(createCenter(), BorderLayout.CENTER);
        }
        cp.revalidate();
        cp.repaint();
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Dữ liệu mẫu để test (có thể thêm nhiều hơn 9 để thấy cuộn)
        for (int i = 1; i <= 5; i++) {
            store.addMedia(new DigitalVideoDisc("DVD " + i, "Action", "Director" + i, 120, 19.95f));
        }
        store.addMedia(new Book("Java Programming", "Education", 15.5f));
        store.addMedia(new CompactDisc("Thriller", "Music", "John Landis", 42, 19.99f, "Michael Jackson"));
        new StoreManagerScreen(store);
    }
}