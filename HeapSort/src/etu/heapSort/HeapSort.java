package etu.heapSort;

import java.util.Objects;

public class HeapSort{
	public int arr[];

    class BinTree{
        public BinTree left;            // левое и правое поддеревья и ключ
        public BinTree right;
        public int key;

        public BinTree(int i){ // конструктор с инициализацией ключа
            key = i;
        }

        public void create(int[] arr){  // корень бин.дер. уже существет - достраиваем остальное
            int i = 1;
            while (!Objects.equals(i, arr.length)){
                insert(new BinTree(arr[i++]));
            }
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
    }

	public HeapSort(int[] arr){
		this.arr = arr;
		BinTree bt = new BinTree(arr[0]);
		bt.create(arr);
	}

	public int[] getSortedArray(){
		return  arr;
	}


}


