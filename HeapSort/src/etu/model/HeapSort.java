package etu.model;

//import java.io.File;
import java.util.Objects;


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

interface VisitorBT{
    void visit(BinTree node);
}

class SortProcess implements VisitorBT {
    private static int instanceCounter = 0;
    private int counter;
    private int arr[];

    SortProcess(int[] arr) {
        this.arr = arr;
    }

    public void visit(BinTree node){
        counter = instanceCounter++;
        printArr(arr);
        arr[counter] = node.key;

    }

    private void printArr(int[] arr) {
        for (Integer i : arr){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

    // public int getNumColumnsOfTree(int arr[]){
    //     int n = arr.length;
    //     int count = 0;
    //     for (int i = 0; i < n / 2; ) {
    //         while (n-Math.pow(2, i) >= 0) {
    //             count++;
    //             i++;
    //         }
    //     }
    //     System.out.println(count);
    //     return count;
    // }

}




