package etu.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Press & see terminal", 40, 10);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 200, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    public ButtonsPanel() {
        super(null);
        add(StartSort);
        StartSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Я кнопка и я работаю");
//                e ->
            }
        });
    }


//    public void addStartSort(AncestorListener listener) {
//        StartSort.addAncestorListener(listener);
//    }
}