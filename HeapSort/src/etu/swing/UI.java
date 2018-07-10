package etu.swing;

import etu.controller.Controller;
import etu.model.FileReadArray;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class UI extends JFrame {
    private final JPanel readPanel;
    private final JPanel controlPanel;
    private final JPanel graphPanel;
//    private static final ButtonsPanel buttonPanel = null;
//    private static final ReadDataPanel dataPanel = null;

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
        super("Heap Sort Visualisation");
        setPreferredSize(new Dimension(1000, 700));
        setResizable(true);

        Scanner in = new Scanner(new File("resource/input.dat"));
        try {
            in = new Scanner(new File("resource/input.dat"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        FileReadArray fileArr = FileReadArray.init(in);
        in.close();
        Controller controller = new Controller(fileArr);

        ButtonsPanel buttonPanel = new ButtonsPanel(controller);
        ReadDataPanel dataPanel = new ReadDataPanel(controller);

        readPanel = new JPanel();
        readPanel.setPreferredSize(new Dimension(300, 20));
        readPanel.setLayout(new BoxLayout(readPanel, BoxLayout.X_AXIS));

        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(20, 100));
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));

        dataPanel.setBounds(350, 20, 150, 120);
        dataPanel.setPreferredSize(new Dimension(300, 200));
        buttonPanel.setPreferredSize(new Dimension(190, 100));
        buttonPanel.setBounds(350, 10, 150, 120);

        readPanel.add(dataPanel);
        readPanel.add(Box.createRigidArea(new Dimension(110, 20)));

        controlPanel.add(buttonPanel);
        controlPanel.add(Box.createRigidArea(new Dimension(110, 20)));

        graphPanel = new JPanel();
        graphPanel.setPreferredSize(new Dimension(400, 500));
        graphPanel.setBorder(new TitledBorder("Graph"));
        controller.setGraphPanel(graphPanel);

        JPanel rootPanel = new JPanel();
        rootPanel.setPreferredSize(new Dimension(10, 200)); // size of MainWindow
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));

        rootPanel.add(readPanel);
        rootPanel.add(graphPanel);
        rootPanel.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null); // position window in center
        rootPanel.setVisible(true);
    }

}
