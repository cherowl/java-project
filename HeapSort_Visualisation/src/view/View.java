package src.view;

import src.heapSort.HeapSort;

public class View {
    private final static int CIRCLE_SIZE = 30;
    private final static int LEVEL_SIZE = 20;

    private Graphics graphics;

    public void draw(HeapSort heapSort){
        drawSortArray(heapSort);
        drawGraphArray(heapSort);
    }

    private void drawSortArray(HeapSort heapSort){  //draw of sorted array
        int lenght = heapSort.getSortArr().length;
        for (int i = 0; i < lenght; i++) {
            graphics.drawRect();
        }
    }
    private void drawGraphArray(HeapSort heapSort){

    }
}
