package etu.controller;

import etu.model.FileReadArray;
import etu.swing.UI;

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
        System.out.println("text");
        if (UI.getUpPanel().getTextField().getText().length() != 0){
            this.readFile = readFile.reedFromTextField(UI.getUpPanel().getTextField().getText());
        }
    }

    public void startSort(){
//        System.out.println("text");
        checkTextField();
//        Model.clearListOfTrees();
//        ProjectLauncher.getProgressBar().clear();
//        readFile.startSort();
//        viewUpdated();
    }

    public void nextStep(){
        System.out.println("i'm next");

//        notifyAll();
//        BuildGraph gr = new BuildGraph(hp.getBinArr());
//        gr.build();
    }

    public void previousStep(){
        System.out.println("i'm previous");
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