package session11_tree_and_map.homeworks.using_arraylist_and_linkedlist;
import java.util.*;
public class SortAscendingPrice implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getPrice() - p2.getPrice();
    }
}
