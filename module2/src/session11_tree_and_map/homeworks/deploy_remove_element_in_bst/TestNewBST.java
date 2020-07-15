package session11_tree_and_map.homeworks.deploy_remove_element_in_bst;

import session11_tree_and_map.homeworks.deploy_bst_preorder_and_postorder_traversal.BST;

public class TestNewBST<E> {
    public static void main(String[] args) {
        NewBST<Integer> newBST = new NewBST<>();
        newBST.insertNode(10);
        newBST.insertNode(4);
        newBST.insertNode(5);
        newBST.insertNode(2);
        newBST.insertNode(3);
        newBST.insertNode(8);
        newBST.insertNode(7);
        newBST.insertNode(6);
        newBST.insertNode(9);
        newBST.insertNode(19);
        newBST.insertNode(25);
        newBST.insertNode(27);
        newBST.insertNode(29);
        newBST.insertNode(30);
        newBST.insertNode(28);
        newBST.insertNode(20);
        newBST.insertNode(18);
        newBST.insertNode(13);
        newBST.insertNode(12);
        newBST.insertNode(15);



        newBST.showBST(newBST.root);
        System.out.println();
        System.out.println("Tree has number 20? " + newBST.hasNode(20));
        System.out.println("-----------------------------");
        newBST.removeNode(newBST,18);
        newBST.showBST(newBST.root);
    }
}
