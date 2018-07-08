package etu.model.heapsort.BinTree;

public class BinTree {
    NodeTree root;

    private NodeTree addRecursive(NodeTree current, int value, int lvl) {
        if (current == null) {
            return new NodeTree(value, lvl);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value, lvl);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value, lvl);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value, int lvl) {
        root = addRecursive(root, value, lvl);
    }

    public int utilLevel(NodeTree n){
        if (n == null) {
            return 0;
        }
        return Math.max(utilLevel(n.left), utilLevel(n.right))+1;
    }

    public void setLevel(NodeTree root) {
        if (root.left!=null) setLevel(root.left);
        root.level = this.utilLevel(root);
        if (root.right!=null) setLevel(root.right);
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