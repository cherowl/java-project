package etu.model.heapsort.BinTree;

public class BinTree {

    NodeTree root;
    int[] arr;

    public BinTree(int[] arr) {
        this.arr = arr;
    }

    public void culcateLevel(NodeTree root) {

    }

    private NodeTree addRecursive(NodeTree current, int value, int lvl) {
        if (current == null) {
            return new NodeTree(value, lvl);
        }
        if ( value < current.value) {
            current.left = addRecursive(current.left, value,current.level+1);
        } else if ( value > current.value) {
            current.right = addRecursive(current.right, value,current.level+1);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void CreateBinTree(){
        int lvl = 0;

        for (int i = 0; i < arr.length; i++) {
            if(root == null)
                lvl = 0;
            else lvl = root.level;
            root = addRecursive(root, arr[i], lvl);
        }
    }



    public NodeTree getRoot() {
        return root;
    }

    public void printTree(NodeTree root){
        System.out.println(root.value + " (" + root.level + ") ");
        if (root.left!=null) printTree(root.left);
        if (root.right!=null) printTree(root.right);
    }

    public static int size(NodeTree node) {
        if(node == null)
            return 0;
        else
            return size(node.left) + 1 + size(node.right);
    }
}