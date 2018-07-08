package etu.model.heapsort.BinTree;

public class BinTree {

    NodeTree root;
    int[] arr;

    public BinTree(int[] arr) {
        this.arr = arr;
    }

//    private NodeTree addRecursive(NodeTree current, int value, int lvl, int i) {
//        if (current == null) {
//            return new NodeTree(value, lvl);
//        }
//        if (value < current.value) {
//            current.left = addRecursive(current.left, value, lvl+1);
//        } else if (value > current.value) {
//            current.right = addRecursive(current.right, value, lvl+1);
//        } else {
//            // value already exists
//            return current;
//        }
//
//        return current;
//    }


    public NodeTree createRecursive(NodeTree current, int lvl, int i) {
        if (current == null && i < arr.length) {
            return new NodeTree(arr[i], lvl);
        }

        if ( i < arr.length && arr[i] < current.value) {
            current.left = createRecursive(current.left, lvl+1, i+1);
        } else if (i < arr.length && arr[i] > current.value) {
            current.right = createRecursive(current.right, lvl+1, i+1);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void culcateLevel(NodeTree root) {

    }

//    public BinTree CreateBinTree(){
//        root = new NodeTree(arr[0], 0);
//        for (int i = 0; i < arr.length; i++) {
//            addRecursive(root, arr[i], 1);
//        }
//        return ;
//    }



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