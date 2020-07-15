package session11_tree_and_map.practice.deploy_binary_search_tree;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree() {
    }

    public BinarySearchTree(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /* create a new root */
        else {
            /* locate the parent node */
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.data) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.data) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; /* Duplicate node not inserted */
                }
            }

            if (e.compareTo(parent.data) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /* element inserted successfully */
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

