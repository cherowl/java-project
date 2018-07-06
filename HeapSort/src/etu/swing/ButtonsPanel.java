package etu.swing;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Start Sort", 40, 10);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        return left;
    }

    public ButtonsPanel() {
        super(null);
        add(StartSort);
    }


    public void addStartSort(AncestorListener listener) {
        StartSort.addAncestorListener(listener);
    }
}