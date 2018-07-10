package etu.swing;

import etu.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataPanel extends JPanel {

    private final JButton openFile = createButton("Open file", 40, 40);
    private final JLabel enter = createLabel("Enter array for sort:", 0, 20, 50, 30);
    private final JTextField textField = createTextField("", 0, 40, 50, 30);

    private JButton createButton(String text, int x, int y) {
        return ButtonsPanel.getjButton(text, x, y);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        return label;
    }

    private JTextField createTextField(String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField(text, 15);
        textField.setBounds(x, y, width, height);
        return textField;
    }

    public JTextField getTextField() {
        return textField;
    }

    public ReadDataPanel(Controller controller) {
        add(openFile);
        add(enter);
        add(textField);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.openFile();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.reedFromTextField(textField.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}