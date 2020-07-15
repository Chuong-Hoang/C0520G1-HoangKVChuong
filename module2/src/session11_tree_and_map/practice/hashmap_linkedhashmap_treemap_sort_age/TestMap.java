package session11_tree_and_map.practice.hashmap_linkedhashmap_treemap_sort_age;
import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        // Create HashMap to store list of students
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Hoang Kim Van Chuong", 32);
        hashMap.put("Le Nhat", 22);
        hashMap.put("Tu Si Tung", 25);
        hashMap.put("Nguyen Huu Quang", 24);
        hashMap.put("Phan Quoc Khanh", 28);
        hashMap.put("Nguyen Tien Hai", 21);
        hashMap.put("Tran Huu Hien", 26);
        hashMap.put("Nguyen Tran Dat", 27);
        hashMap.put("Tran Phuoc Vuong", 30);
        hashMap.put("Tran Thanh Hoang", 24);
        hashMap.put("Le Toan", 28);
        hashMap.put("Vo Son Tra", 26);

        System.out.println("--Display entries in HashMap--");
        System.out.println("Browse by using keySet");
        for (String key : hashMap.keySet()) {
            System.out.println("Key = " + key + " =>" + hashMap.get(key));
        }
        System.out.println();

        System.out.println("Browse by using entrySet");
        for (Map.Entry<String, Integer> student : hashMap.entrySet()) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Browse by using Iterator");
        Set<String> newKeys = hashMap.keySet();
        Iterator<String> iteratorKeys = newKeys.iterator();
        String k;
        while(iteratorKeys.hasNext()) {
            k = iteratorKeys.next();
            System.out.println("$" + k + " --> " + hashMap.get(k));
        }


        System.out.println("------------------------------------");

        // Create TreeMap to store keys by sorting ascending order
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("--Display entries in TreeMap with ascending order of keys--");
        int i = 1;
        for (String key : treeMap.keySet()) {
            System.out.println("Key " + i + ": " + key + " --> " + treeMap.get(key));
            i++;
        }

        // Create LinkedHashMap to store list of students
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Nguyet", 22);
        linkedHashMap.put("Tien", 28);
        linkedHashMap.put("Minh", 32);
        linkedHashMap.put("Diep", 20);
        linkedHashMap.put("Phuong", 25);
        System.out.println();

        // Display LinkedHashMap (support sort entries)
        System.out.println("Display entries in LinkedHashMap");
        Set<String> keys = linkedHashMap.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String val = iterator.next();
            System.out.println("Key $" + val + ": " + linkedHashMap.get(val));
        }
    }
}
