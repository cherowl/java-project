package etu.model.heapsort;

import etu.model.heapsort.BinTree.BinTree;
import etu.model.heapsort.BinTree.NodeTree;

class SortProcess implements VisitorBT {
    private int[] arr;
    private BinTree[] binArr;
    private static int instanceCounter = 0;
    private int counter;


    SortProcess(int[] arr) {
        this.arr = arr;
        this.binArr = new BinTree[arr.length];
    }

    public void visit(NodeTree node){
        counter = instanceCounter++;
        arr[counter] = node.getValue();
        binArr[counter] = (new BinTree(arr)).createBinTree();

        System.out.println(counter);
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (Integer i : arr){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

    public BinTree[] getBinArr() {
        return binArr;
    }
}
