package src.swing;

import javax.swing.*;
import javax.swing.event.AncestorListener;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Start Sort", 750, 5);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 90, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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