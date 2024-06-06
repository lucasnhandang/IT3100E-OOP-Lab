package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.screen.manager.StoreManagerScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected JFrame frame;
    protected Store store;
    JButton addButton;


    public AddItemToStoreScreen(Store store) {
        this.store = store;
        frame = new JFrame();

        // frame
        setTitle("Add item");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setVisible(true);

        // menu bar
        add(createMenuBar(), BorderLayout.NORTH);

        // button for 3 kinds of adding items
        addButton = new JButton("Add");
        addButton.addActionListener(e -> addItemToStore());
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);
        viewStoreMenu.addActionListener(new btnMenuListener());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new StoreManagerScreen(store);
            dispose();
        }
    }

    protected abstract void addItemToStore();
}
