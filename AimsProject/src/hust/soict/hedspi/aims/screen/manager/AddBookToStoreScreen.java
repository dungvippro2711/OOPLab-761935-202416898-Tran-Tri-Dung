package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;

    public AddBookToStoreScreen(Store store, StoreManagerScreen parent) {
        super(store, parent);
    }

    @Override
    protected void setupUI() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        inputPanel.add(tfCategory);

        inputPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        inputPanel.add(tfCost);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                Book book = new Book(title, category, cost);
                addItemAndClose(book);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please check again.");
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnCancel);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }
}