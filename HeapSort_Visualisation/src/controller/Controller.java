package src.controller;

import src.heapSort.HeapSort;
import src.view.View;

public class Controller {
    private final HeapSort heapSort;
    private final View view;

    public Controller(HeapSort heapSort, View view) {
        this.heapSort = heapSort;
        this.view = view;
    }

    public void viewUpdated(){
        view.draw(heapSort);

    }
}
