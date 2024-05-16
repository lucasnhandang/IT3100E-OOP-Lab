package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaHome extends JDialog {
    public MediaHome(Media media) {
        setPreferredSize(new Dimension(400, 200));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        JLabel infoLabel = new JLabel(((Playable)media).toString());
        JLabel des = new JLabel("Now playing... Enjoy~");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(des, BorderLayout.NORTH);
        panel.add(infoLabel, BorderLayout.CENTER);
        panel.add(closeButton, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
