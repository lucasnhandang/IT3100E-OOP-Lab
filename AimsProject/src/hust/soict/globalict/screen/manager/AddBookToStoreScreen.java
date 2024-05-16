package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JLabel titleLabel, categoryLabel, costLabel, authorLabel;
    private JTextField titleField, categoryField, costField, authorField;
    private JTextArea authorsArea;
    private JPanel authorsPanel;
    private JButton addAuthorButton;
    private ArrayList<String> authors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        super.setTitle("Add Book");

        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        authorLabel = new JLabel("Authors:");
        costLabel = new JLabel("Cost:");

        titleField = new JTextField();
        categoryField = new JTextField();
        authorField = new JTextField();
        costField = new JTextField();

        authors = new ArrayList<>();
        authorsPanel = new JPanel(new BorderLayout());
        authorsArea = new JTextArea();

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(costLabel);
        panel.add(costField);

        panel.add(authorLabel);
        panel.add(authorField);

        //this.add(panel, BorderLayout.CENTER);

        authorsArea.setEditable(false);
        authorsPanel.add(new JScrollPane(authorsArea), BorderLayout.CENTER);

        addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(e -> addAuthors());
        authorsPanel.add(addAuthorButton, BorderLayout.SOUTH);

        //this.add(authorsPanel, BorderLayout.CENTER);

        this.add(createCenter(panel, authorsPanel), BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);
    }

    JPanel createCenter (JPanel p1, JPanel p2) {
        JPanel panel = new JPanel(new BorderLayout());

        panel.add(p1, BorderLayout.NORTH);
        panel.add(p2, BorderLayout.CENTER);

        return panel;
    }

    private void addAuthors () {
        String author = authorField.getText();
        if (!author.isEmpty()) {
            authors.add(author);
            authorsArea.append(author + "\n");
            authorField.setText("");
        }
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());

        Book book = new Book(title, category, cost, authors);
        store.addMedia(book);

        JOptionPane.showMessageDialog(frame, "Book added successfully.");
        new StoreManagerScreen(store);

        dispose();
    }
}
