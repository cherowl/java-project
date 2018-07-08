package etu.model.heapsort.BinTree;

public class NodeTree {
	int value;
	int level;
	NodeTree left;
	NodeTree right;

	NodeTree(int value, int lvl) {
		this.value = value;
		this.level = lvl;
		right = null;
		left = null;
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
}