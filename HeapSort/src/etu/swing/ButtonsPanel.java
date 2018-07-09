package etu.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    private final JButton startSort = createButton("Start sort", 40, 40);
    private final JButton next = createButton("Next step", 40, 40);
    private final JButton previous = createButton("Previous step", 40, 40);

    private JButton createButton(String text, int x, int y) {
        return getjButton(text, x, y);
    }

    static JButton getjButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }


    public ButtonsPanel() {
        add(previous);
        add(startSort);
        add(next);
    }

    void addStartSortButtonListener(ActionListener listener){
        startSort.addActionListener(listener);
    }

    void addNextStepButtonListener(ActionListener listener){
        next.addActionListener(listener);
    }

    void addPreviousStepButtonListener(ActionListener listener) {
        previous.addActionListener(listener);
    }

}
