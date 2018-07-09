package etu.controller;

import etu.model.FileReadArray;
import etu.model.heapsort.HeapSort;
import etu.swing.UI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
//    private final HeapSort heapSort;
    private FileReadArray readFile;
//    private final View view;

    public Controller(/*HeapSort heapSort, View view, */FileReadArray readFile) {
//        this.heapSort = heapSort;
//        this.view = view;
        this.readFile = readFile;
    }

    private void checkTextField(){ //понадобится для старта
        if (UI.getUpPanel().getTextField().getText().length() != 0){
            this.readFile = readFile.reedFromTextField(UI.getUpPanel().getTextField().getText());
        }
    }

    public void startSort(){
        checkTextField();
//        Model.clearListOfTrees();
//        ProjectLauncher.getProgressBar().clear();
        readFile.startSort();
//        viewUpdated();
    }

    public void nextStep(){
//        notifyAll();
        Scanner in = null;
        try {
            in = new Scanner(new File("resource/input.dat"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        FileReadArray fileArr = FileReadArray.init(in);
        HeapSort hp = new HeapSort(fileArr.getArray());
//        BuildGraph gr = new BuildGraph(hp.getBinArr());
//        gr.build();
    }

    public void previousStep(){
        //реализовать
//        if (currentSlide - 1 >= 0){
//            currentSlide -= 2;
//            UI.getProgressBar().setCurrentSlide(currentSlide + 1);
//            notifyAll();
        }
    }

//    public void viewUpdated(){
//        if (this.view.isAlive()) this.view = null;
//        this.view = new View();
//        this.view.setGraphics(new SwingGraphicsAdapter(ProjectLauncher.getCanvas().getGraphics()));
//        this.view.start();
//    }
//}