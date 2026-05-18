package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;

import javax.swing.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected StoreManagerScreen parentScreen;

    public AddItemToStoreScreen(Store store, StoreManagerScreen parent) {
        this.store = store;
        this.parentScreen = parent;
        setTitle("Add Item to Store");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setupUI();
    }

    protected abstract void setupUI();

    protected void addItemAndClose(Media media) {
        store.addMedia(media);
        parentScreen.refreshCenter();
        JOptionPane.showMessageDialog(this, "Item added successfully!");
        dispose();
    }
}