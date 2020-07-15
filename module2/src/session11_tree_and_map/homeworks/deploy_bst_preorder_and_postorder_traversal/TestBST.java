package session11_tree_and_map.homeworks.deploy_bst_preorder_and_postorder_traversal;

public class TestBST {
    public static void main(String[] args) {
        // create a BST
        BST<Integer> myTree = new BST<>();
        myTree.insertNewNode(15);
        myTree.insertNewNode(17);
        myTree.insertNewNode(16);
        myTree.insertNewNode(20);
        myTree.insertNewNode(12);
        myTree.insertNewNode(14);
        myTree.insertNewNode(19);
        myTree.insertNewNode(25);
        myTree.insertNewNode(10);
        myTree.insertNewNode(11);
        myTree.insertNewNode(8);
        myTree.insertNewNode(5);

        //pre-order traversal
        System.out.println("Pre-order sort:");
        myTree.preOrder();
        System.out.println();

        //post-order traversal
        System.out.println("Post-order sort:");
        myTree.postOrder();
        System.out.println();

        //in-order traversal
        System.out.println("In-order sort:");
        myTree.inOrder();
    }
}
