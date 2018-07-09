package etu.swing;

import etu.controller.Controller;
import etu.model.FileReadArray;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UI extends JFrame {
    private final JPanel rightPanel;
    private final JPanel graphPanel;
    private static final ButtonsPanel buttonPanel = null;
    private static final ReadDataPanel dataPanel = null;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new UI().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private UI() throws HeadlessException, IOException {
        setPreferredSize(new Dimension(1000, 700));
        setResizable(true);

        Scanner in = new Scanner(new File("resource/input.dat"));
        try {
            in = new Scanner(new File("resource/input.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileReadArray fileArr = FileReadArray.init(in);
        Controller controller = new Controller(fileArr);

        ButtonsPanel buttonPanel = new ButtonsPanel(controller);
        ReadDataPanel dataPanel = new ReadDataPanel(controller);
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(150, 400));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        buttonPanel.setPreferredSize(new Dimension(190, 100));
        buttonPanel.setBounds(300, 0, 150, 120);
        rightPanel.add(dataPanel);
        rightPanel.add(buttonPanel);
        rightPanel.add(Box.createRigidArea(new Dimension(110, 20)));

        graphPanel = new JPanel();
        graphPanel.setPreferredSize(new Dimension(400, 180));
        graphPanel.setBorder(new TitledBorder("Graph"));
        controller.setGraphPanel(graphPanel);

        JPanel rootPanel = new JPanel();
        rootPanel.setPreferredSize(new Dimension(10, 200)); // size of MainWindow
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS));

        rootPanel.add(graphPanel);
        rootPanel.add(rightPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null); // position window in center
        rootPanel.setVisible(true);
    }

}
