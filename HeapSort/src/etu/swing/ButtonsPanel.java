package etu.swing;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    // private final JButton startSort = createButton("Start sort", 40, 10);
    private final JButton nextStep = createButton("Next step", 40, 10);

    public ButtonsPanel() {
        super(null);
        // add(startSort);
        add(nextStep);
    }

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    // public void addStartSort(AncestorListener listener) {
    //     startSort.addAncestorListener(listener);
    // }

    public void addNextStep(AncestorListener listener) {
        nextStep.addAncestorListener(listener);
    }

}