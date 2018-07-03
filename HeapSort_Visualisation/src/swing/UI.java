package src.swing;

<<<<<<< HEAD:HeapSort_Visualisation/src/swing/UI.java
import src.controller.Controller;
import src.heapSort.FileReadArray;
import src.heapSort.HeapSort;
=======
import etu.controller.Controller;

import etu.heapSort.FileReadArray;
import etu.heapSort.HeapSort;
import etu.view.View;
>>>>>>> d38038146ca23d5f5bd399155761b492c9b27d38:HeapSort_Visualisation/src/etu/swing/UI.java

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
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

    private  UI() throws HeadlessException {
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
<<<<<<< HEAD:HeapSort_Visualisation/src/swing/UI.java
        //TODO Scaner blabla
        ///home/elena/java/java-project/HeapSort_Visualisation/resource
        Scanner in = new Scanner(new File("./../resource/input.dat"));
        FileReadArray f = FileReadArray.init(in);
=======
        Scanner in = new Scanner(new File("C:/Users/Sergey/IdeaProjects/HeapSort_Visualisation/resource/input.dat"));
        FileReadArray file = FileReadArray.init(in);

        HeapSort heapSort = new HeapSort(file.getArray());

        View view = new View();
        view.setGraphics(new SwingGraphicsAdapter(this, canvas.getGraphics()));

        Controller controller = new Controller(heapSort, view, file);
>>>>>>> d38038146ca23d5f5bd399155761b492c9b27d38:HeapSort_Visualisation/src/etu/swing/UI.java

        buttons.addStartSort(new AncestorListener()){
                @Override
                public void ancestorAdded(AncestorEvent event) {

                }
            });
        );

        Timer timer = new Timer(50, e -> { controller.viewUpdated(); canvas.requestFocus(); });
        timer.setRepeats(true);
        timer.start();
    }
}
