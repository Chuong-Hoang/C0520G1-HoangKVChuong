package session11_tree_and_map.homeworks.deploy_search_element_in_bst;

public class MyBST<E extends Comparable<E>> {
    protected TreeNode<E> root;

    public MyBST() {
    }

    public void addNode(E e) {
        if (this.root == null) {
            this.root = new TreeNode<>(e);
            System.out.println("Root added " + e);
        } else {
            TreeNode<E> temp = this.root;
            TreeNode<E> father = null;
            while (temp != null) {
                if (e.compareTo(temp.data) < 0) {
                    father = temp;
                    temp = temp.left;
                } else if (e.compareTo(temp.data) > 0) {
                    father = temp;
                    temp = temp.right;
                } else {
                    System.out.println("Cannot add node value " + e);
                }
            }

            if (e.compareTo(father.data) < 0) {
                father.left = new TreeNode<>(e);
                System.out.println("Left added " + e);
            } else {
                father.right = new TreeNode<>(e);
                System.out.println("Right added " + e);
            }
        }
    }

    public void displayTree(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.data + " -- ");
            displayTree(root.left);
            displayTree(root.right);
        }
    }

    public void search(E e) {
        boolean isMatched = false;
        if(this.root != null) {
            TreeNode<E> temp = this.root;
            while(temp != null) {
                if (e.compareTo(temp.data) == 0) {
                    isMatched = true;
                    break;
                } else if (e.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }
        }
        if(isMatched) System.out.println(e + " is in the BST.");
        else System.out.println(e + " is NOT in the BST.");
    }
}
