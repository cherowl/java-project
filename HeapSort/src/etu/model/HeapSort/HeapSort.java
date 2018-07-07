package etu.model.HeapSort;


public class HeapSort{
    private int arr[];
    private BinTree[] binArr;

    public HeapSort(int[] arr){
        this.arr = arr;
        BinTree bt = new BinTree(arr[0]);
        bt.create(arr);
        SortProcess sp = new SortProcess(arr);
        bt.traverse(sp);
        bt.setLevel();
        this.binArr = sp.getBinArr();

    }

    public int[] getSortedArray() {
        return  arr;
    }

    public BinTree[] getBinArr() {
        return binArr;
    }


}




