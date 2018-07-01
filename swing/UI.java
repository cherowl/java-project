package etu.swing;

import javafx.application.Application;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame{

    private final ButtonsPanel buttons;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new UI().setVisible(true));
    }

    private  UI() throws HeadlessException {
        JFrame mainFrame = new JFrame("Visualisation of Graph"); // new basics window

        JPanel rootPanel = new JPanel();
        buttons = new ButtonsPanel();

        Component canvas = mainFrame.add(rootPanel);
        canvas.setPreferredSize(new Dimension(1000, 500));

        rootPanel.add(buttons, BorderLayout.CENTER);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
    }
}
