package etu.swing;

import etu.model.FileReadArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

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

    public ReadDataPanel() {
        add(openFile);
        add(enter);
        add(textField);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnVal = fileChooser.showDialog(null, "Открыть файл");
                FileReadArray file = FileReadArray.init( new Scanner(String.valueOf(fileChooser.getSelectedFile()))); //как-нибудь привести

            }
        });
    }
}