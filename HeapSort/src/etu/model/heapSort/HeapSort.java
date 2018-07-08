package etu.model.heapSort;


import etu.model.heapsort.BinTree.BinTree;

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


    public int[] getArray() {
        return  arr;
    }

    public BinTree[] getBinArr() {
        return binArr;
    }
<<<<<<< HEAD:HeapSort/src/etu/model/heapsort/HeapSort.java

    public void printArray(){
        for (Integer i : arr){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

=======
>>>>>>> master:HeapSort/src/etu/model/heapSort/HeapSort.java
}




