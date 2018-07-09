package etu.controller;

import etu.model.BuildGraph;
import etu.model.FileReadArray;
import etu.model.heapsort.BinTree.BinTree;
import etu.model.heapsort.HeapSort;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    private FileReadArray readFile;
    private HeapSort heapSort = null;
    private BinTree binTree;
    private Graph graph = null;
    private int count = 0;
    private JPanel graphPanel = null;

    public Controller(FileReadArray readFile) {
        this.readFile = readFile;
//        readFile.printArray();
    }

    public void updateView(){
        BuildGraph gb = new BuildGraph(binTree.getRoot());
        Graph graph = gb.build();

        graphPanel.removeAll();

        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.disableAutoLayout(); //graph will tend to make nodes tied with each other close
        View view = viewer.addDefaultView(false);
        view.getCamera().resetView();
        view.getCamera().setViewPercent(2.5); //This will zoom of 200% on the view center.

        ((ViewPanel) view).setPreferredSize(new Dimension(525, 630));
//        graphPanel = new JPanel();
        graphPanel.add((JPanel) view);
//        graphPanel.setPreferredSize(new Dimension(300, 180));
//        graphPanel.setBorder(new TitledBorder("Graph"));
        graphPanel.updateUI();
    }

    public void startSort(){
        System.out.println("Init mas: ");
        readFile.printArray();
        heapSort = new HeapSort(readFile.getArray());
        System.out.print("Sorted array: ");
        heapSort.printArray();
        binTree = heapSort.getBinArr()[0];
        System.out.println();
        updateView();
    }

    public void nextStep(){
        if(heapSort == null)
            JOptionPane.showMessageDialog(null, "You should press Start Sort", "Attention", JOptionPane.ERROR_MESSAGE);
        else {
            if (count < heapSort.getBinArr().length){
                count += 1;
                binTree = heapSort.getBinArr()[count];
                binTree.printTree(binTree.getRoot());
                System.out.println();
                updateView();
            }
            else {
                JOptionPane.showMessageDialog(null, "The algorithm finished", "Attention", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void prevStep(){
        if(heapSort == null)
            JOptionPane.showMessageDialog(null, "You should press Start Sort", "Attention", JOptionPane.ERROR_MESSAGE);
        else {
            if (count > 0) {
                count -= 1;
                binTree = heapSort.getBinArr()[count];
                binTree.printTree(binTree.getRoot());
                updateView();
            }
            else {
                JOptionPane.showMessageDialog(null, "The previous step doesn't exist yet", "Attention", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public BinTree getBinTree() {
        if( binTree == null){
            System.out.println("NULL POINTER");
        }
        return binTree;
    }

    public void setGraphPanel(JPanel graphPanel) {
        this.graphPanel = graphPanel;
    }

    public void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(null, "Открыть файл");
        FileReadArray file = null; //как-нибудь привести
        try {
            file = FileReadArray.init( new Scanner(fileChooser.getSelectedFile()));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
//        return file;
        this.readFile = file;
    }

//
//    public FileReadArray reedFromTextField(String text){
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (String i : text.split(" ")){
//            list.add(Integer.parseInt(i));
//        }
//        return restore(list);
//    }
}