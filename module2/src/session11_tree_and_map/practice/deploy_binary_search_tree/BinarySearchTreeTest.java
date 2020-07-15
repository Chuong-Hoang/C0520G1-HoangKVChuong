package session11_tree_and_map.practice.deploy_binary_search_tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {

        // create a BST
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("Chuong");
        tree.insert("Hoang");
        tree.insert("Nguyen");
        tree.insert("Hong");
        tree.insert("James");
        tree.insert("Bond");
        tree.insert("Craig");
        tree.insert("Daniel");

        // traverse tree
        System.out.println("In-order (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes: " + tree.getSize());
    }
}
