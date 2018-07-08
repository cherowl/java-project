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

    public void createBinTree(){
        for (int i = 0; i < arr.length; i++) {
            root = addRecursive(root, arr[i], null);
        }
    }



//    public int utilLevel(NodeTree n){
//        if (n == null) {
//            return 0;
//        }
//        return Math.max(utilLevel(n.left), utilLevel(n.right))+1;
//    }

//    public void setLevel(NodeTree root) {
////        if (root.left!=null) setLevel(root.left);
////        root.level = this.utilLevel(root);
////        if (root.right!=null) setLevel(root.right);
//        if (root.left!=null) setLevel(root.left);
//        root.level = this.findHeight(root);
//        if (root.right!=null) setLevel(root.right);
////        int ilev = 0;
////        if (root != null){
////            btMas[indexRoot].lev = btMas[p].lev + 1;
////            putlevels(indexRoot, left(indexRoot));
////            putlevels(indexRoot, right(indexRoot));
////        }
//    }

    public NodeTree getRoot() {
        return root;
    }

    public void printTree(NodeTree root){
        if(root != null){
            System.out.println(root.value + " (" + root.level + ") ");
            if (root.left!=null) printTree(root.left);
            if (root.right!=null) printTree(root.right);
        }
    }

    public static int size(NodeTree node) {
        if(node == null)
            return 0;
        else
            return size(node.left) + 1 + size(node.right);
    }

}
