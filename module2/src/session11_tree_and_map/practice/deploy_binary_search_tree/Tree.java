package session11_tree_and_map.practice.deploy_binary_search_tree;

public interface Tree<E> {
    /**
     * Insert element e into the binary seach tree.
     * Return true if the element is insert successfully.
     */
    public boolean insert(E e);

    /**
     * In-order traversal from the root
     */
    public void inorder();

    /**
     * Get the number of nodes in the tree
     */
    public int getSize();
}
