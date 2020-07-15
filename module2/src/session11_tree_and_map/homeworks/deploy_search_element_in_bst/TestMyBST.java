package session11_tree_and_map.homeworks.deploy_search_element_in_bst;

public class TestMyBST {
    public static void main(String[] args) {
        MyBST<Integer> newBST = new MyBST<>();
        newBST.addNode(10);
        newBST.addNode(4);
        newBST.addNode(5);
        newBST.addNode(2);
        newBST.addNode(3);
        newBST.addNode(8);
        newBST.addNode(7);
        newBST.addNode(6);
        newBST.addNode(19);
        newBST.addNode(25);
        newBST.addNode(20);
        newBST.addNode(18);
        newBST.addNode(13);
        newBST.addNode(12);
        newBST.addNode(15);

        newBST.displayTree(newBST.root);
        System.out.println();
        newBST.search(20);
        newBST.search(30);
        newBST.search(17);
        newBST.search(5);
        newBST.search(15);

    }
}
