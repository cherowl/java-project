package etu.swing;

import etu.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    private final JButton StartSort = createButton("Push me", 40, 10);
    private final JLabel check = createLabel("lalalla", 40, 250);
//    private final JFrame mainFrame;

    private JButton createButton(String text, int x, int y) {
        JButton left = new JButton(text);
        left.setBounds(x, y, 200, 40); //size of buttons
        left.setFocusPainted(false);
        left.setBorderPainted(true);
        left.setBackground(Color.LIGHT_GRAY);
        return left;
    }

    private JLabel createLabel(String text, int x, int y){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 40);
//        label.(true);
        return label;
    }

    public ButtonsPanel() {
        add(StartSort);
        add(check);
        StartSort.addActionListener(new ActionListener() {
//            private JEditorPane jTextArea1;
//            View view = new View(mainFrame);
//            @Override
            public void actionPerformed(ActionEvent e) {
//                view.showThanksDialog();
//                System.out.println("Я кнопка и я работаю");
            }
        });
    }

//    public void addStartSort(AncestorListener listener) {
//        StartSort.addAncestorListener(listener);
//    }

//    @Override
//    public void showCongratsDialog() {
//        JOptionPane.showConfirmDialog(mainFrame, "You are winner!", "Congratulations", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
//    }
}