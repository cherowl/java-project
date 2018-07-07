package etu.model.HeapSort;

import java.util.Objects;

public class BinTree{
    private int key;
    private int level;
    private BinTree left;            // левое и правое поддеревья и ключ
    private BinTree right;


    public void create(int[] arr){
        int i = 1;
        while (!Objects.equals(i, arr.length)){
            insert(new BinTree(arr[i++]));
        }
    }

    public BinTree(int i){ // конструктор с инициализацией ключа
        key = i;
//        level = 0;
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

    public void print(){
        System.out.print(this.key+"("+this.level+") ");
    }
    public int getKey(){
        return key;
    }

    public int utilLevel(BinTree b){
        if (b == null) {
            return 0;
        }
        else return Math.max(utilLevel(b.getLeft()), utilLevel(b.getRight()))+1;
    }

    public void setLevel() {
        this.level = this.utilLevel(this);
    }

    public int getLevel() {
        return level;
    }

    public BinTree getLeft() {
        if(left != null) {
            return left;
        }
        return null;
    }

    public BinTree getRight() {
        if(right != null) {
            return right;
        }
        return null;
    }

    public void printTree(){
            this.print();
            if (left!=null) left.printTree();
            if (right!=null) right.printTree();
        }
}
