package etu.controller;

import etu.model.FileReadArray;
import etu.model.heapsort.BinTree.BinTree;
import etu.model.heapsort.HeapSort;

public class Controller {
    private final FileReadArray readFile;

    private HeapSort heapSort = null;
    private BinTree binTree;
    private int count = 0;

    public Controller(FileReadArray readFile) {
        this.readFile = readFile;
    }

    public void StartSort(){
        heapSort = new HeapSort(readFile.getArray());
        System.out.print("Sorted array: ");
        binTree = heapSort.getBinArr()[0];
        System.out.println("testttttt");
    }


    public void nextStep(){
        if(heapSort == null)
            System.out.println("Can you push Start Sort");
        else {
            if (count < heapSort.getBinArr().length)
                count += 1;
            binTree = heapSort.getBinArr()[count];
        }
    }

    public void prevStep(){
        if(heapSort == null)
            System.out.println("Can you push Start Sort");
        else {
            if (count > 0)
                count -= 1;
            binTree = heapSort.getBinArr()[count];
        }
    }

    public BinTree getBinTree() {
        if( binTree == null){
            System.out.println("NULL POINTER");
        }
        return binTree;
    }
}