package etu.swing;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Sort", 40, 10);

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 100, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    public ButtonsPanel() {
        super(null);
        add(StartSort);
//        StartSort.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Scanner in = null;
//                try {
//                    in = new Scanner(new File("resource/input.dat"));
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                }
//
//            }
//        });
    }

}