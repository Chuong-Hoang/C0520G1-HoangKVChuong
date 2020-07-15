package session11_tree_and_map.demo.hash_map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class HashMapDemo {
    public static void main(String[] args) {
//        HashMap<String, Integer> customers = new HashMap<>();
//        customers.put("Chuong", 32);
//        customers.put("Hong", 30);
//        customers.put("Duy", 25);
//        customers.put("Hang", 35);
//        customers.put("Nguyen", 28);
//
//        Set<String> keys = customers.keySet();
//        Iterator<String> iterator = keys.iterator();
//        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println("key: " + s + ": " + customers.get(s));
//        }
        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("John", 30);
        customers.put("Mike", 28);
        customers.put("Bill", 32);
        customers.put("Maria", 27);

        Set<String> keys = customers.keySet();
        for (String key: keys){
            System.out.println("Key: " + key + ": " + customers.get(key));
        }
    }
}
