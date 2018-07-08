package etu.model.heapsort.BinTree;

public class BinTree {
    NodeTree root;
    public int[] arr;

    public BinTree(int[] arr) {
        this.arr = arr;
    }

//    private NodeTree addRecursive(NodeTree current, int value, int lvl) {
//        if (current == null) {
//            return new NodeTree(value, lvl);
//        }
//
//        if (value < current.value) {
//            current.left = addRecursive(current.left, value, lvl);
//        } else if (value > current.value) {
//            current.right = addRecursive(current.right, value, lvl);
//        } else {
//            // value already exists
//            return current;
//        }
//
//        return current;
//    }
    private NodeTree addRecursive(NodeTree current, int lvl, int i) {
        if (current == null) {
            return new NodeTree(arr[i], lvl);
        }
        if (arr[i] < current.value) {
            current.left = addRecursive(current.left, lvl+1, i+1);
        } else if (arr[i] > current.value) {
            current.right = addRecursive(current.right, lvl+1, i+1);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void CreateBinTree(){
        root = new NodeTree(arr[0], 0);
        addRecursive(root, 0, 0);
    }


    public void add(int value, int lvl) {
        root = addRecursive(root, value, lvl);
    }

//        private NodeTree addRecursive(NodeTree current, int value, int lvl, int i) {
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