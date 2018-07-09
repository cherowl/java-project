package etu.swing;

import etu.controller.Controller;
import etu.model.BuildGraph;
import etu.model.FileReadArray;
import etu.model.heapsort.HeapSort;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

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
    private static final ButtonsPanel buttonsPanel = new ButtonsPanel();
    private static final ReadDataPanel upPanel = new ReadDataPanel();

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
        setResizable(false);

        ButtonsPanel buttons = new ButtonsPanel();
        ReadDataPanel up = new ReadDataPanel();
        graphPanel = new JPanel();
        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(150, 400));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

//        buttons.setPreferredSize(new Dimension(190, 100));
//        buttons.setBounds(300, 0, 150, 120);
        rightPanel.add(up);
        rightPanel.add(buttons);
//        rightPanel.add(Box.createRigidArea(new Dimension(110, 20)));


        JPanel rootPanel = new JPanel();
        rootPanel.setPreferredSize(new Dimension(10, 200)); // size of MainWindow
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS)); //WARNINNNGGGGGGG!
        rootPanel.add(Box.createRigidArea(new Dimension(10, 400)));

        rootPanel.add(graphPanel);
//        rootPanel.add(Box.createRigidArea(new Dimension(10, 700)));
        rootPanel.add(rightPanel);
//        rootPanel.add(Box.createRigidArea(new Dimension(10, 700)));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null); // position window in center
        rootPanel.setVisible(true);

        Scanner in = new Scanner(new File("resource/input.dat"));
        FileReadArray fileArr = FileReadArray.init(in);
        Controller controller = new Controller(fileArr);

        buttonsPanel.addStartSortButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startSort();
            }
        });

        buttonsPanel.addNextStepButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextStep();
            }
        });

        buttonsPanel.addPreviousStepButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.prevStep();
            }
        });

            BuildGraph graphB = new BuildGraph(heapSort.getBinArr()[0].getRoot());
            Graph graph = graphB.build();
            Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            viewer.disableAutoLayout(); //graph will tend to make nodes tied with each other close
            View view = viewer.addDefaultView(false);
            view.getCamera().resetView();
            view.getCamera().setViewPercent(2.5); //This will zoom of 200% on the view center.
//--------------------------------------------------------------------------------
            ((ViewPanel) view).setPreferredSize( new Dimension(525, 630));
            graphPanel.add((JPanel)view);

            graphPanel.setPreferredSize(new Dimension(300, 180));
            graphPanel.setBorder(new TitledBorder("Graph"));


            rootPanel.add(graphPanel);

    }

}
