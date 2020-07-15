package session11_tree_and_map.homeworks.deploy_remove_element_in_bst;

import session11_tree_and_map.practice.deploy_binary_search_tree.Tree;

public class NewBST<E extends Comparable<E>> {
    public TreeNode<E> root;

    public NewBST() {
    }

    public void insertNode(E e) {
        if (this.root == null) {
            this.root = new TreeNode<>(e);
        } else {
            TreeNode<E> temp = this.root;
            TreeNode<E> ancestor = null;
            while (temp != null) {
                if (e.compareTo(temp.data) < 0) {
                    ancestor = temp;
                    temp = temp.left;
                } else if (e.compareTo(temp.data) > 0) {
                    ancestor = temp;
                    temp = temp.right;
                } else {
                    System.out.println(e + " not inserted!");
                }
            }

            if (e.compareTo(ancestor.data) < 0) {
                ancestor.left = new TreeNode<>(e);
            } else {
                ancestor.right = new TreeNode<>(e);
            }
        }
    }

    public boolean hasNode(E e) {
        boolean isMatched = false;
        TreeNode<E> temp = this.root;
        while (temp != null) {
            if (e.compareTo(temp.data) == 0) {
                isMatched = true;
                break;
            } else if (e.compareTo(temp.data) < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return isMatched;
    }

    public void showBST(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            showBST(root.left);
            showBST(root.right);
        }
    }

    public void removeNode(NewBST<E> tree, E e) {
        if (!tree.hasNode(e)) {
            System.out.println("Tree does not have node " + e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> temp = this.root;
            while (e.compareTo(temp.data) != 0) {
                parent = temp;
                if (e.compareTo(temp.data) < 0) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }

            TreeNode<E> rightTemp = temp.right;
            if (e.compareTo(parent.data) < 0) {
               if (temp.left == null) {
                   parent.left = temp.right;
               } else {
                   if (rightTemp == null) {
                       temp = temp.left;
                       parent.left = temp;
                   } else {
                       parent.left = rightTemp;
                       rightTemp.left = temp.left;
                   }
               }
            }

            if (e.compareTo(parent.data) > 0) {
               if (temp.left == null) {
                   parent.right = temp.right;
               } else {
                   if (rightTemp == null) {
                       temp = temp.left;
                       parent.right = temp;
                   } else {
                       parent.right = rightTemp;
                       rightTemp.left = temp.left;
                   }
               }
            }
        }
    }
}
