package etu.view;

import etu.model.HeapSort;

public class View {
    private final static int CIRCLE_SIZE = 30;
    private final static int LEVEL_SIZE = 20;

    private Graphics graphics;

    public void draw(HeapSort heapSort){
        drawSortedArray(heapSort);
        drawGraphArray(heapSort);
    }

    private void drawSortedArray(HeapSort heapSort){  //draw of sorted array
        int lenght = heapSort.getSortedArray().length;
        int[] arr =  heapSort.getSortedArray();
        for (int i = 0; i < lenght; i++) {
            graphics.drawRect(300, 60 + i*30, 30, 30, arr[i]);
        }
    }

    public void showThanks(){
        graphics.showThanks();
    }

    private void drawGraphArray(HeapSort hp){ //draw tree
        // TODO
        hp.printSortedTrace();
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
