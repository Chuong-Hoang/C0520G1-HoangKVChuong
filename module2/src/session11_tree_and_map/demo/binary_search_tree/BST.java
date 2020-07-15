package session11_tree_and_map.demo.binary_search_tree;

public class BST {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
    }
}

class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected TreeNode<E> root;

    public TreeNode(E e) {
        element = e;
    }
}
