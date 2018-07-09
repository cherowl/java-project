package etu.swing;

import etu.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    private final JButton start = createButton("Start sort", 40, 40);
    private final JButton next = createButton("Next step", 40, 40);
    private final JButton prev = createButton("Previous step", 40, 40);

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

    public ButtonsPanel(Controller controller) {
        add(prev);
        add(start);
        add(next);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startSort();
            }
        });

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.prevStep();
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextStep();
            }
        });



    }

}