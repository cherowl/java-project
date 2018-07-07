package etu.model;

//import java.io.File;
import java.util.Objects;


public class HeapSort{
    public int arr[];
    public int[][] arrTrace;
    // private final File metaData;

    public HeapSort(int[] arr){
        this.arr = arr;
        this.arrTrace = new int[arr.length][arr.length];
        BinTree bt = new BinTree(arr[0]);
        bt.create(arr);
        bt.traverse(new SortProcess(arr, arrTrace));

        System.out.println();
        printSortedTrace();
    }

    public int[] getSortedArray() {
        return  arr;
    }

    public void printArray(int[] array) {
        for (Integer i : array){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

    public void printSortedTrace() {
        for(int i = 0; i<arrTrace.length; i++){
            printArray(arrTrace[i]);
        }
        System.out.println();
    }
}

class BinTree{
    public BinTree left;            // левое и правое поддеревья и ключ
    public BinTree right;
    public int key;

    public void create(int[] arr){
        int i = 1;
        while (!Objects.equals(i, arr.length)){
            insert(new BinTree(arr[i++]));
        }
    }

    public BinTree(int i){ // конструктор с инициализацией ключа
        key = i;
    }

    /*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
    public void insert(BinTree bt){
        if (bt.key < key)
            if (left != null) left.insert(bt);
            else left = bt;
        else if (right != null) right.insert(bt);
        else right = bt;
    }
    /*  visit (обход)
        Рекурсивно обойти левое поддерево.
        Применить функцию f (печать) к корневому узлу.
        Рекурсивно обойти правое поддерево.
    */
    public void traverse(VisitorBT visitor){
        if (left != null)
            left.traverse(visitor);

		visitor.visit(this);

        if (right != null)
            right.traverse(visitor);
    }
}

interface VisitorBT{
    void visit(BinTree node);
}

class SortProcess implements VisitorBT {
    private static int instanceCounter = 0;
    private int counter;
    private int[] arr;
    private int[][] arrTrace;

    SortProcess(int[] arr, int[][] trace) {
        this.arr = arr;
        this.arrTrace = trace;
    }

    public void visit(BinTree node){
        counter = instanceCounter++;
        arrTrace[counter] = arr;
        arr[counter] = node.key;

        System.out.println(counter);
        printArr(arrTrace[counter]);
    }

//    public int[][] getSortedTrace(){
//        return arrTrace;
//    }

    private void printArr(int[] array) {
        for (Integer i : array){
            System.out.print(" "+i.intValue());
        }
        System.out.println();
    }

}




