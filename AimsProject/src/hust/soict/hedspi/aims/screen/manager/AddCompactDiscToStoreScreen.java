package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost, tfArtist;

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen parent) {
        super(store, parent);
    }

    @Override
    protected void setupUI() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        inputPanel.add(tfTitle);

        inputPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        inputPanel.add(tfCategory);

        inputPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        inputPanel.add(tfDirector);

        inputPanel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        inputPanel.add(tfLength);

        inputPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        inputPanel.add(tfCost);

        inputPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        inputPanel.add(tfArtist);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length = Integer.parseInt(tfLength.getText().trim());
                float cost = Float.parseFloat(tfCost.getText().trim());
                String artist = tfArtist.getText().trim();
                CompactDisc cd = new CompactDisc(title, category, director, length, cost, artist);
                addItemAndClose(cd);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please check numbers.");
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