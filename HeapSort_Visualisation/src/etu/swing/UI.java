package etu.swing;

import etu.controller.Controller;

import etu.heapSort.FileReadArray;
import etu.heapSort.HeapSort;
import etu.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI extends JFrame{

    private final ButtonsPanel buttons;
    private final Component canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new UI().setVisible(true));
    }

    private  UI() throws HeadlessException, FileNotFoundException {
        JPanel rootPanel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(Color.cyan);
                g.fillRect(5, 5, 700, 600); //size of inside window
            }
        };

        buttons = new ButtonsPanel();
        canvas = new JPanel();

        canvas.setPreferredSize(new Dimension(900, 600));
        buttons.setPreferredSize(new Dimension(900, 400));

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS)); //WARNINNNGGGGGGG!
        rootPanel.setPreferredSize( new Dimension(950, 600)); // size of MainWindow

        rootPanel.add(buttons, BorderLayout.SOUTH);
        rootPanel.add(canvas, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null); // position window in center

        initListners();
    }

    private void initListners() throws FileNotFoundException {
        Scanner in = new Scanner(new File("C:/Users/Sergey/IdeaProjects/HeapSort_Visualisation/resource/input.dat"));
        FileReadArray file = FileReadArray.init(in);

        HeapSort heapSort = new HeapSort(file.getArray());

        View view = new View();
        view.setGraphics(new SwingGraphicsAdapter(this, canvas.getGraphics()));

        Controller controller = new Controller(heapSort, view, file);

        buttons.addStartSort(e -> controller.StartSort())); //ERROR HERE

        canvas.addKeyListener( new KeyAdapter() {
               @Override
               public void keyReleased(KeyEvent event) {

                       controller.StartSort();

               }
           }
        );

        Timer timer = new Timer(50, e -> { controller.viewUpdated(); canvas.requestFocus(); });
        timer.setRepeats(true);
        timer.start();
    }
}
