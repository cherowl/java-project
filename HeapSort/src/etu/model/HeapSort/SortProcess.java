package etu.model.HeapSort;

class SortProcess implements VisitorBT {
    private int[] arr;
    private BinTree[] binArr;
    private static int instanceCounter = 0;
    private int counter;


    SortProcess(int[] arr) {
        this.arr = arr;
        this.binArr = new BinTree[arr.length];
    }

    public void visit(BinTree node){
        System.out.println(counter);
        binArr[counter] = node;
        counter = instanceCounter++;
//        if (node.getRight() != null){
//            System.out.println(node.getRight().getLevel());
//        }

        arr[counter] = node.getKey();
        printArr(arr);

    }

    private void printArr(int[] arr) {
        for (Integer i : arr){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

    public BinTree[] getBinArr() {
        return binArr;
    }
}
