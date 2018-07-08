package etu.model.heapsort.BinTree;

import etu.model.heapsort.VisitorBT;

public class NodeTree {
	int value;
	int level;
	NodeTree left;
    NodeTree right;
    NodeTree parent;

	NodeTree(int value, NodeTree parent) {
		this.value = value;
        this.parent = parent;
		setLevel();
		left = null;
	}

    int depth(NodeTree node)
    {
        if(node.parent == null)
            return 0;
        return 1+depth(node.parent);
    }

    public void setLevel() {
        this.level = this.depth(this);
    }

    public int getValue() {
	    return value;
	}

	public int getLevel() {
	    return level;
	}

	public NodeTree getLeft() {
	    return left;
	}

	public NodeTree getRight() {
		return right;
	}

    public void print() {
        System.out.println(value);
    }

	/*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
//	public void insert(NodeTree bt){
//		if (bt.value < value)
//			if (bt.left != null) bt.left.insert(bt);
//			else bt.left = bt;
//		else if (bt.right != null) bt.right.insert(bt);
//		else bt.right = bt;
//	}
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

	public int getParent() {
		return parent.getValue();
	}
}

