package etu.model.heapsort;


import etu.model.heapsort.BinTree.BinTree;
import etu.model.heapsort.BinTree.NodeTree;

public class HeapSort{
    private int arr[];
    private BinTree[] binArr;

    public HeapSort(int[] arr){
        this.arr = arr;
        BinTree bt = new BinTree(arr);
        bt.createBinTree();
        SortProcess sp = new SortProcess(arr);
        bt.getRoot().traverse(sp);
        this.binArr = sp.getBinArr();
    }


    public int[] getSortedArray() {
        return  arr;
    }

    public BinTree[] getBinArr() {
        return binArr;
    }


}




