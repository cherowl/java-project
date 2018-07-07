package etu.swing;

import etu.model.FileReadArray;
import etu.model.HeapSort;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;


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
        HeapSort hp = new HeapSort(FileReadArray());
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

//        HeapSort heapSort = new HeapSort();


        String path = "./resource/outGraph.dat";
        FileSource metaData = FileSourceFactory.sourceFor(path);

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
        Graph graph = new SingleGraph("G", false, true);

        metaData.addSink(graph);
        try {
            metaData.readAll(path);
        } catch( IOException ignored) {
        } finally {
            metaData.removeSink(graph);
        }

//        Node a = graph.addNode("A");
//        a.setAttribute("xy", 0, 0, "ui.label");
//        Node b = graph.addNode("B");
//        b.setAttribute("xy", -2, -1);
//        Node c = graph.addNode("C");
//        c.setAttribute("xy", 2, -1);
//        Node d = graph.addNode("D");
//        d.setAttribute("xy", -3, -2);
//        Node e = graph.addNode("E");
//        e.setAttribute("xy", -1, -2);
//        Node f = graph.addNode("F");
//        f.setAttribute("xy", 1, -2);
//        Node g = graph.addNode("G");
//        g.setAttribute("xy", 3, -2);
//
//        Edge AB = graph.addEdge("AB", "A", "B", true);
////        graph.addEdge("AB", "A", "B", true).addAttribute("length", 14);
//        AB.addAttribute("ui.label", "RIGHT");
//        graph.addEdge("AC", "A", "C", true);
//        graph.addEdge("BD", "B", "D", true);
//        graph.addEdge("BE", "B", "E", true);
//        graph.addEdge("CF", "C", "F", true);
//        graph.addEdge("CG", "C", "G", true);

        for (Node node : graph){
            node.addAttribute("ui.label", node.getId());

        }


//        for (Edge  edge : graph.getEachEdge()){
//            edge.addAttribute("label", "" );//+ (int) edge.getNumber("length"));
//        }

        graph.addAttribute("ui.stylesheet",
                "graph{fill-color: #E2DFDF;} " +
                        "node{ " +
                        "shape: circle;  " +
                        "size: 20px, 20px; " +
                        "fill-color: white;" +
                        "stroke-mode: plain;" +
                        "text-mode: normal;" +
                        "text-mode: normal; " +
                        "text-style: bold; " +
                        "text-size: 13; " +
                        "text-alignment: center;" +
                        "size-mode: dyn-size;}");

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.disableAutoLayout(); //graph will tend to make nodes tied with each other close
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
