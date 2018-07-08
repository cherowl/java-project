package etu.model.heapsort.BinTree;

public class NodeTree {
	int value;
	int level;
	int parent;
	NodeTree left;
	NodeTree right;

	NodeTree(int value, int lvl) {
		this.value = value;
		this.level = lvl;
//		this.parent =
//		this.setLevel();
        System.out.println("makelav: "+lvl);
		right = null;
		left = null;
	}

//    public setParent()

    public int findHeight(NodeTree aNode) {
        if (aNode == null) {
            return -1;
        }
//        while(aNode.id != )
        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    public void setLevel(NodeTree head) {
        System.out.print(" foundlev: "+this.findHeight(head));
//        this.level = this.findHeight(this);
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