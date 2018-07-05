package etu.view;

import etu.heapSort.HeapSort;

public class View {
    private final static int CIRCLE_SIZE = 30;
    private final static int LEVEL_SIZE = 20;

    private Graphics graphics;

    public void draw(HeapSort hp){
        drawSortedArray(hp);
//        drawGraphArray(heapSort);
    }

    private void drawSortedArray(HeapSort hp){  //draw of sorted array
        int lenght = hp.getSortedArray().length;
        int[] arr =  hp.getSortedArray();
        for (int i = 0; i < lenght; i++) {
            graphics.drawRect(300, 60 + i*30, 30, 30, arr[i]);
        }
    }

    public void showThanks(){
        graphics.showThanks();
    }

//    private void drawGraphArray(HeapSort heapSort){ //draw tree
//        // TODO
//    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
