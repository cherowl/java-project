package etu.model.HeapSort;

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
}
