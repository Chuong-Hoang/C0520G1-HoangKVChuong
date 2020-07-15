package session11_tree_and_map.homeworks.deploy_bst_preorder_and_postorder_traversal;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
   protected TreeNode<E> root;
   protected int size = 0;

   public BST() {}

   public BST(E[] list) {
       for(int i = 0; i < list.length; i++)
           insertNewNode(list[i]);
   }


    @Override
    public boolean insertNewNode(E e) {
        if (this.root == null) {
            this.root = createFreshNode(e);
        } else {
           TreeNode<E> parent = null;
           TreeNode<E> temp = this.root;
           while (temp != null) {
               if(e.compareTo(temp.data) < 0) {
                   parent = temp;
                   temp = temp.left;
               } else if(e.compareTo(temp.data) > 0) {
                   parent = temp;
                   temp = temp.right;
               } else {
                   return false; // cannot insert node
               }
           }
           if (e.compareTo(parent.data) < 0) {
               parent.left = createFreshNode(e);
           } else {
               parent.right = createFreshNode(e);
           }
        }
        size++;
        return true; // insert successfully
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public int getTreeSize() {
        return size;
    }

    public void inOrder(TreeNode<E> root) {
        if (root == null) return;
        else {
            inOrder(root.left);
            System.out.print(root.data + " - ");
            inOrder(root.right);
        }
    }

    public void preOrder(TreeNode<E> root) {
        if(root == null) return;
        else {
            System.out.print(root.data + "$ -->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode<E> root) {
       if(root == null) return;
       else {
           postOrder(root.left);
           postOrder(root.right);
           System.out.print(root.data + "$ <-- ");
       }

    }

    protected TreeNode<E> createFreshNode(E e) {
       TreeNode<E> treeNode = new TreeNode<E>(e);
       return treeNode;
    }
}




