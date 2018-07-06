package etu.swing;

import etu.model.HeapSort;
import etu.model.BinTree;
import etu.model.FileReadArray;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceFactory;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.spriteManager.*;

import java.io.Writer;
import java.util.Iterator;
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


        Scanner input = new Scanner(new File("resource/input.dat"));
        FileReadArray fileArr = FileReadArray.init(input);
        HeapSort heapSort = new HeapSort(fileArr.getArray());
//        heapSort.getSortedArray();

//        String path = "C:/./resource/outGraph.dat";
//        FileSource metaData = FileSourceFactory.sourceFor(path);

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

//        metaData.addSink(graph);
//        try {
//            metaData.readAll(path);
//        } catch( IOException ignored) {
//        } finally {
//            metaData.removeSink(graph);
//        }
//
//        Node a = graph.addNode("A");
//        a.setAttribute("xy", 0, 0);
////        a.setAttribute("label", "2");
//        Node b = graph.addNode("B");
//        b.setAttribute("xy", -2, -1);Node b = graph.addNode("B");
////        b.setAttribute("xy", -2, -1);
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
//        graph.addEdge("AB", "A", "B", true);
//        graph.addEdge("AC", "A", "C", true);
//        graph.addEdge("BD", "B", "D", true);
//        graph.addEdge("BE", "B", "E", true);
//        graph.addEdge("CF", "C", "F", true);
//        graph.addEdge("CG", "C", "G", true);

        int[] arr = heapSort.getSortedArray();
//
        Iterator<Node> node = graph.getNodeIterator();
        int d = arr.length*2;
        int level = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            Node w = graph.addNode(String.valueOf(i));
//            for (int m = 0; m < arr.length / 2; ) {
//                while (arr.length - Math.pow(2, m) >= 0) {
//                    level++;
//                    m++;
//                }
//            }
             if(i%2==0){
                n++;
            }
            else{
                d = d/2;
            }
            w.setAttribute("xy", Math.pow((-1), i)*d*i, -n*i);

            w.setAttribute("label", arr[i]);
        }

        Iterator<Node> edge = graph.getNodeIterator();
        int k = 0;
        for (int i = 0; i < arr.length-1; i++) {
            graph.addEdge(String.valueOf(i), String.valueOf(k), String.valueOf(i+1), true);
            if(i%2!=0){
                k++;
            }
        }






//        BinTree bt = new BinTree(arr[0]);
//        bt.create(arr);
//        bt.traverse();



//    for (int i = 0; i < arr.length; i++){
//        for (Node node : graph){
//            node.addAttribute("label", node.key);
//        }
//    }

//        for (Node node : graph){
//            node.addAttribute("label", node.getAttributeCount());
//        }

        graph.addAttribute("ui.antialias");

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
                ((ViewPanel) view).setPreferredSize( new Dimension(750, 640));

                JPanel graphPanel = new JPanel();
                graphPanel.add((JPanel)view);

        graphPanel.setPreferredSize(new Dimension(800, 700));
        graphPanel.setBorder(new TitledBorder("Graph"));

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(Box.createRigidArea(new Dimension(1000, 10)));
        leftPanel.add(graphPanel);
        leftPanel.add(Box.createRigidArea(new Dimension(1000, 10)));

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
