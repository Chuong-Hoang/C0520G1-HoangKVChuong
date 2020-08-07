package session_consolidation.co_treeSet_treeMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Student, String> studentStringMap = new TreeMap<>();
        Student st1 = new Student("11", "Hien", "P/Y", 28);
        Student st2 = new Student("22", "Nhat", "QT", 22);
        Student st3 = new Student("33", "Toan", "DN", 29);
        Student st4 = new Student("44", "Hien", "Phu_Yen", 28);
        Student st5 = new Student("55", "Quang", "DN", 27);
        Student st6 = new Student("66", "Hien", "Phu*Yen", 28);
        Student st7 = new Student("77", "Binh", "Hanoi", 28);

        studentStringMap.put(st1, st1.getId()); //Hien-->(11)-->44-->66
        studentStringMap.put(st2, st2.getId()); // Nhat -->22
        studentStringMap.put(st3, st3.getId()); // Toan-->33
        studentStringMap.put(st4, st4.getId()); // Hien-->44 !!!
        studentStringMap.put(st5, st5.getId()); // Quang-->55
        studentStringMap.put(st6, st6.getId()); // Hien-->66 !!!
        studentStringMap.put(st7, st7.getId()); // Binh-->77

        Set<Student> keys = studentStringMap.keySet();
        System.out.println("TREE_MAP");
        System.out.println("TreeSet and TreeMap need to @Override compareTo()...");
        int i = 1;
        for(Student st : keys) {
            System.out.println(i + ". " + st.toString() + " --> Id: " + studentStringMap.get(st));
            i++;
        }
    }


}
