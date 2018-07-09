package etu.controller;

import etu.model.FileReadArray;
import etu.model.heapsort.BinTree.BinTree;
import etu.model.heapsort.HeapSort;

public class Controller {
    private final FileReadArray readFile;
    private HeapSort heapSort = null;
    private BinTree binTree;
//    private BuildGraph graph = null;
    private int count = 0;

    public Controller(FileReadArray readFile) {
        this.readFile = readFile;
    }

    public void startSort(){
        System.out.println("TEST");
        heapSort = new HeapSort(readFile.getArray());
        System.out.print("Sorted array: ");
        binTree = heapSort.getBinArr()[0];
//        graph = new BuildGraph(binTree.getRoot());

    }

    public void nextStep(){
        if(heapSort == null)
            System.out.println("Can you push Start Sort");
        else {
            if (count < heapSort.getBinArr().length)
                count += 1;
            binTree = heapSort.getBinArr()[count];
//            graph = new BuildGraph(binTree.getRoot());

        }
    }

    public void prevStep(){
        if(heapSort == null)
            System.out.println("Can you push Start Sort");
        else {
            if (count > 0)
                count -= 1;
            binTree = heapSort.getBinArr()[count];
//            graph = new BuildGraph(binTree.getRoot());
        }
    }

    public BinTree getBinTree() {
        if( binTree == null){
            System.out.println("NULL POINTER");
        }
        return binTree;
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