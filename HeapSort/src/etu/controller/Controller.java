package etu.controller;

import etu.heapSort.FileReadArray;
import etu.heapSort.HeapSort;
import etu.view.View;

public class Controller {

    private final HeapSort hp;
    private final FileReadArray readFile;
    private final View view;

    public Controller(View view, FileReadArray readFile) {
        this.hp = new HeapSort(readFile.getArray());
        this.view = view;
        this.readFile = readFile;
    }

    public void viewUpdated(){
        view.draw(hp);
    }

    public void StartSort(){
        view.draw(hp);
    }

}
