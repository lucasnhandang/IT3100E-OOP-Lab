package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JLabel titleLabel, categoryLabel, costLabel, lengthLabel, directorLabel, artistLabel;
    private JTextField titleField, categoryField, artistField, directorField, costField, lengthField;

    public AddCompactDiscToStoreScreen (Store store) {
        super(store);
        super.setTitle("Add CD");

        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        costLabel = new JLabel("Cost:");
        lengthLabel = new JLabel("Length:");
        directorLabel = new JLabel("Director:");
        artistLabel = new JLabel("Artist:");


        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        lengthField = new JTextField();
        directorField = new JTextField();
        artistField = new JTextField();

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(costLabel);
        panel.add(costField);

        panel.add(lengthLabel);
        panel.add(lengthField);

        panel.add(directorLabel);
        panel.add(directorField);

        panel.add(artistLabel);
        panel.add(artistField);

        this.add(panel, BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
    }
    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        String director = directorField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(frame, "CD added successfully.");
        new StoreManagerScreen(store);

        dispose();
    }
}
