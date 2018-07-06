package etu.heapSort;

import java.util.Objects;

public class HeapSort{

    class BinTree {
        public BinTree left;            // левое и правое поддеревья и ключ
        public BinTree right;
        public int key;
//        private staint count = 0;


        public BinTree(int i) { // конструктор с инициализацией ключа
            key = i;
        }

        public void create(int[] arr) {  // корень бин.дер. уже существет - достраиваем остальное
            int i = 1;
            while (!Objects.equals(i, arr.length- 1)) {
                insert(new BinTree(arr[i++]));
            }
        }

        /*
        insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
        */
        public void insert(BinTree bt) {
            if (bt.key < key)
                if (left != null) left.insert(bt);
                else left = bt;
            else if (right != null) right.insert(bt);
            else right = bt;
        }

        /*
        visit (обход)
		Рекурсивно обойти левое поддерево.
		Применить функцию "sout" (печать) к корневому узлу.
		Рекурсивно обойти правое поддерево.
	    */
        public void visit(BinTree node) {
            if (left != null)
                left.sortProgress(node);

            node.sortProgress(this);

            if (right != null)
                right.sortProgress(node);
        }

        public void sortProgress(BinTree node) {
//            for (int i = 0; i < count; i++) {
//                System.out.print(" ");
//            }

//            getSortedArray()[count] = node.key;
            System.out.println(node.key);

        }
    }
        public int arr[];
        public int arrSorted[];

        public HeapSort(int[] arr){
            this.arr = arr;
            this.arrSorted = arr.clone();
            BinTree bt = new BinTree(arr[0]);
            bt.create(arr);
            bt.visit(bt);

        }

        public int[] getSortedArray(){
            return  arrSorted;
        }



}




