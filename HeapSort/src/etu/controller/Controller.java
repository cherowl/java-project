package etu.controller;

import etu.model.FileReadArray;
import etu.model.heapsort.HeapSort;
import org.graphstream.graph.Graph;

public class Controller {
    private final HeapSort heapSort;
    private final FileReadArray readFile;
    private final Graph graph;
    private BinTree binTree;
    private count = 0;

    public Controller(HeapSort heapSort, FileReadArray readFile,  Graph graph) {
        this.heapSort = heapSort;
        this.readFile = readFile;
        this.graph = graph;
        this.count = 0;
    }

    public void StartSort(){
        HeapSort hp = new HeapSort(readFile.getArray());
        System.out.print("Sorted array: ");
        binTree = hp.getBinArr()[0];
        System.out.println("testttttt");
    }

    public void nextStep{
        if( count < hp.getBinArr()[].lenght )
        count +=1;
        binTree = hp.getBinArr()[count];
    }

    public void prevStep{
        if(count > 0)
            count -=1;
        binTree = hp.getBinArr()[count];
    }
}