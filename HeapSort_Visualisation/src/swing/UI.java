package src.swing;

import src.controller.Controller;
import src.heapSort.FileReadArray;
import src.heapSort.HeapSort;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI extends JFrame{

    private final ButtonsPanel buttons;
    private final Component canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new UI().setVisible(true));
    }

    private  UI() throws HeadlessException {
        JPanel rootPanel = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(Color.cyan);
                g.fillRect(5, 5, 700, 700); //size of inside window
            }
        };

        buttons = new ButtonsPanel();
        canvas = new JPanel();

        canvas.setPreferredSize(new Dimension(900, 750));
        buttons.setPreferredSize(new Dimension(900, 400));

        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS)); //WARNINNNGGGGGGG!
        rootPanel.setPreferredSize( new Dimension(950, 750)); // size of MainWindow

        rootPanel.add(buttons, BorderLayout.SOUTH);
        rootPanel.add(canvas, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void initListners() throws FileNotFoundException {
        //TODO Scaner blabla
        ///home/elena/java/java-project/HeapSort_Visualisation/resource
        Scanner in = new Scanner(new File("./../resource/input.dat"));
        FileReadArray f = FileReadArray.init(in);

        HeapSort ob = new HeapSort();
        ob.sort(f.getArray());

        Controller = new Controller(ob);

//        Timer timer = new Timer(50, e -> { controller.viewUpdated(); canvas.requestFocus(); });
//        timer.setRepeats(true);
//        timer.start();
    }
}
