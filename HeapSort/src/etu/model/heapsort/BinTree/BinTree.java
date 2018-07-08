package etu.model.heapsort.BinTree;

public class BinTree {
    NodeTree root;
    public int[] arr;

    public BinTree(int[] arr) {
        this.arr = arr;
    }

    private NodeTree addRecursive(NodeTree current, int value, NodeTree parent) {
        if (current == null) {
            return new NodeTree(value, parent);
        }
        if ( value < current.value) {
            current.left = addRecursive(current.left, value, current);
        } else if ( value > current.value) {
            current.right = addRecursive(current.right, value, current);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public BinTree createBinTree(){
        for (int i = 0; i < arr.length; i++) {
            root = addRecursive(root, arr[i], null);
        }
        return this;
    }

    public NodeTree getRoot() {
        return root;
    }

    public static int size(NodeTree node) {
        if(node == null)
            return 0;
        else
            return size(node.left) + 1 + size(node.right);
    }

    public void printTree(NodeTree root){
        if(root != null){
            System.out.print(root.value + " (" + root.level + ") ");
            if (root.left!=null) printTree(root.left);
            if (root.right!=null) printTree(root.right);
        }
    }
}