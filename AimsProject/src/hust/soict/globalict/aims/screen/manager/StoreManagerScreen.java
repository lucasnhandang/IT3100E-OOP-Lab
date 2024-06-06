package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.screen.manager.AddBookToStoreScreen;
import hust.soict.globalict.screen.manager.AddCompactDiscToStoreScreen;
import hust.soict.globalict.screen.manager.AddDigitalVideoDiscToStoreScreen;
import hust.soict.globalict.screen.manager.MediaStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth () {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar () {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        viewStoreMenu.addActionListener(new btnMenuListener());
        menu.add(viewStoreMenu);

        JMenu smUpdateStore = new JMenu("Update store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");

        menu.add(smUpdateStore);
        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCDMenu);
        smUpdateStore.add(addDVDMenu);

        addBookMenu.addActionListener(new btnMenuListener());
        addCDMenu.addActionListener(new btnMenuListener());
        addDVDMenu.addActionListener(new btnMenuListener());

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

    JScrollPane createCenter () {
        JPanel center = new JPanel(new GridBagLayout());

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (!mediaInStore.isEmpty()) {
            int itemsToShow = mediaInStore.size();
            for (int i = 0; i < itemsToShow; i++) {
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = i % 3;
                gbc.gridy = i / 3;
                gbc.insets = new Insets(5, 5, 5, 5);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;

                hust.soict.globalict.screen.manager.MediaStore cell = new MediaStore(mediaInStore.get(i));
                cell.setPreferredSize(new Dimension(300, 150));
                center.add(cell, gbc);
            }
        }

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        return scrollPane;
    }

    private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("View store")) {
                new StoreManagerScreen(store);
            }
            if (cmd.equals("Add Book")) {
                new AddBookToStoreScreen(store);
            }
            if (cmd.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store);
            }
            if (cmd.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store);
            }
            dispose();
        }
    }

    // Test Store Manager Screen
    public static void main (String[] args) {
        Store store = new Store();
        store.initData();
        new StoreManagerScreen(store);
    }
}
