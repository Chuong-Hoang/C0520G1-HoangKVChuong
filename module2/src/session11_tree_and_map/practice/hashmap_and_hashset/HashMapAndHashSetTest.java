package session11_tree_and_map.practice.hashmap_and_hashset;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class HashMapAndHashSetTest {
    public static void main(String[] args) {
        Student st1 = new Student("Chuong", 32, "Quang Tri");
        Student st2 = new Student("Quang", 28, "Da Nang");
        Student st3 = new Student("Toan", 30, "Hue");
        Student st4 = new Student("Nguyen", 22, "Tam Ky");
        Student st5 = new Student("Dat", 26, "Hoi An");
        Student st6 = new Student("Nhung", 19, "Ha Noi");

        // Create HashMap
        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1, st1);
        studentMap.put(2, st2);
        studentMap.put(3, st3);
        studentMap.put(4, st4);
        studentMap.put(5, st5);
        studentMap.put(6, st6);

        System.out.println("<-- Display HashMap -->");
//        for (Integer key : studentMap.keySet()) {
//            System.out.println(studentMap.get(key));
//        }
        for(Map.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(student);
        }
        System.out.println();

        // Create HashSet
        Set<Student> students = new HashSet<Student>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);

        System.out.println(" == Display HashSet == ");
        for (Student student : students) {
            System.out.println(student.toString());
        }

    }
}
