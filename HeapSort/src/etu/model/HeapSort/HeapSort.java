package etu.model.HeapSort;

//import java.io.File;


public class HeapSort{
    public int arr[];
    // private final File metaData;

    public HeapSort(int[] arr){
        this.arr = arr;
        BinTree bt = new BinTree(arr[0]);
        bt.create(arr);
        bt.traverse(new SortProcess(arr));
    }

    public int[] getSortedArray() {
        return  arr;
    }
}




