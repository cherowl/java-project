package etu.model.heapSort;

import etu.model.heapsort.BinTree.NodeTree;

class SortProcess implements VisitorBT {
    private int[] arr;
    private NodeTree[] binArr;
    private static int instanceCounter = 0;
    private int counter;


    SortProcess(int[] arr) {
        this.arr = arr;
        this.binArr = new NodeTree[arr.length];
    }

    public void visit(NodeTree node){
        counter = instanceCounter++;
//        node.setLevel();
        binArr[counter] = node;
//        arr[counter] = node.getKey();
        System.out.println(counter);
        printArr(arr);
//        node.printTree();
        System.out.println();
    }

    private void printArr(int[] arr) {
        for (Integer i : arr){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

    public NodeTree[] getBinArr() {
        return binArr;
    }
}
