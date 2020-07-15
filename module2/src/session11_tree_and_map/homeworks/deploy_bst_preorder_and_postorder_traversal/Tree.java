package session11_tree_and_map.homeworks.deploy_bst_preorder_and_postorder_traversal;

public interface Tree<E> {
    public boolean insertNewNode(E e);

    public void inOrder();

    public void preOrder();

    public void postOrder();

    public int getTreeSize();
}
