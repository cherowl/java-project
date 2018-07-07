package etu.model.HeapSort;

import java.util.Objects;

public class BinTree{
    private int key;
    private int level;
    private BinTree left;            // левое и правое поддеревья и ключ
    private BinTree right;

    private static int instanceCounter = 0;

    public void create(int[] arr){
        int i = 1;
        while (!Objects.equals(i, arr.length-1)){
            insert(new BinTree(arr[i++]));
        }
    }

    public BinTree(int i){ // конструктор с инициализацией ключа
        key = i;
        level = instanceCounter++;

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

    public int getKey(){
        return key;
    }

    public int getLevel() {
        return level;
    }

    public BinTree getLeft() {
        return left;
    }

    public BinTree getRight() {
        return right;
    }

}
