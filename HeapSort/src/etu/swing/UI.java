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

        String path = "C:/Users/Sergey/java-project/HeapSort/resource/outGraph.dat";
        FileSource metaData = FileSourceFactory.sourceFor(path);

        Graph graph = new SingleGraph("G", true, true);

        for (Node node: graph){
            node.addAttribute("label", node.getId());
        }


        graph.addAttribute("ui.stylesheet",
                "graph{fill-color:   gray;} " +
                        "node{ " +
                        "shape: circle;  " +
                        "size:       30px, 30px; " +
                        "fill-color: white;" +
                        "stroke-mode:  plain; }");

        metaData.addSink(graph);
        try {
            metaData.readAll(path);
        } catch( IOException ignored) {
        } finally {
            metaData.removeSink(graph);
        }

        rightPanel.setPreferredSize(new Dimension(200, 700));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        buttons.setPreferredSize(new Dimension(190, 100));
        buttons.setBounds(400, 0, 200, 120);
        rightPanel.add(buttons);
        rightPanel.add(Box.createRigidArea(new Dimension(110, 20)));

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout(); //graph will tend to make nodes tied with each other close
        View view = viewer.addDefaultView(false);
//        view.getCamera().resetView();
//        view.getCamera().setViewPercent(0.5); //This will zoom of 200% on the view center.
        ((ViewPanel) view).setPreferredSize( new Dimension(750, 630));

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



    }

    
}
