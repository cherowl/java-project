package etu.swing;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.spriteManager.*;
import java.util.Scanner;


public class UI extends JFrame {

    private final JPanel rightPanel;
    private final JPanel leftPanel;

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
        setResizable(false);

        ButtonsPanel buttons = new ButtonsPanel();
        rightPanel = new JPanel();
        leftPanel = new JPanel();

        rightPanel.setPreferredSize(new Dimension(200, 700));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        buttons.setPreferredSize(new Dimension(190, 100));
        buttons.setBounds(400, 0, 200, 120);
        rightPanel.add(buttons);
        rightPanel.add(Box.createRigidArea(new Dimension(110, 20)));


        /**
         *                 A(10)
         *                 /  \
         *               /      \
         *             /          \
         *           /              \
         *        B(20)             C(5)
         *        /  \              /  \
         *      /      \          /      \
         *    D(20)     E(30)   F(90)    G(10)
         *     / \        /
         *   /    \      /
         * H(20) I(40) J(34)
         */
        Graph graph = new SingleGraph("G", true, true);
        Node a = graph.addNode("A");
        a.setAttribute("label", 10); // instead of 10 -(must be) the element of the array
        Node b = graph.addNode("B");
        b.setAttribute("label", 20);
        Node c = graph.addNode("C");
        c.setAttribute("label", 5);
        Node d = graph.addNode("D");
        Node e = graph.addNode("E");
        Node f = graph.addNode("F");
        Node g = graph.addNode("G");
        Edge AB = graph.addEdge("AB", "A", "B");
//        graph.addEdge("AB", "A", "B", true).addAttribute("length", 14);
        AB.addAttribute("label", "RIGHT");
        graph.addEdge("AC", "A", "C", true);
        graph.addEdge("BD", "B", "D", true);
        graph.addEdge("BE", "B", "E", true);
        graph.addEdge("CF", "C", "F", true);
        graph.addEdge("CG", "C", "G", true);
        graph.addAttribute("ui.stylesheet", "graph { fill-color: #E2DFDF; }");

//        for (Node n : graph)
//            n.addAttribute("label", n.getId());
        for (Edge  n : graph.getEachEdge())
            e.addAttribute("label", "" + (int) e.getNumber("length"));

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout(); //graph will tend to make nodes tied with each other close
        View view = viewer.addDefaultView(false);
        view.getCamera().resetView();
//        view.getCamera().setViewPercent(2); //This will zoom of 200% on the view center.
        ((ViewPanel) view).setPreferredSize( new Dimension(750, 640));

        JPanel graphPanel = new JPanel();
        graphPanel.add((JPanel)view);

        graphPanel.setPreferredSize(new Dimension(800, 700));
        graphPanel.setBorder(new TitledBorder("Graph"));

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(Box.createRigidArea(new Dimension(1000, 10))); ///what is it?
        leftPanel.add(graphPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(1000, 10))); ///what is it?

        JPanel rootPanel = new JPanel();
        rootPanel.setPreferredSize(new Dimension(1000, 700)); // size of MainWindow
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.X_AXIS)); //WARNINNNGGGGGGG!
        rootPanel.add(Box.createRigidArea(new Dimension(10, 700)));

        rootPanel.add(graphPanel);
        rootPanel.add(Box.createRigidArea(new Dimension(10, 700)));
        rootPanel.add(rightPanel);
        rootPanel.add(Box.createRigidArea(new Dimension(10, 700)));


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //close app when close main window
        setContentPane(rootPanel);
        pack();
        setLocationRelativeTo(null); // position window in center
        rootPanel.setVisible(true);

    }

    
}
