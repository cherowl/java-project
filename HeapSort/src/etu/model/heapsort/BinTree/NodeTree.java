package etu.model.heapsort.BinTree;

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


}