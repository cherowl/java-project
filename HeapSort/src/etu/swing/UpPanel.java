package etu.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpPanel extends JPanel {

    private final JButton fileOpen = createButton("Open file", 40, 40);
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

    public UpPanel() {
        add(fileOpen);
        add(enter);
        add(textField);

        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("i'm open");
                JFileChooser fileChooser = new JFileChooser();
                int file1 = fileChooser.showDialog(null, "Выберите файл");
//                File choice = ;
//                Scanner choice = new Scanner(fileChooser.getName()); //как-нибудь привести
//                FileReadArray fileReadArray = FileReadArray.init(choice);
//                System.out.print(fileReadArray);
            }
        });
    }
}