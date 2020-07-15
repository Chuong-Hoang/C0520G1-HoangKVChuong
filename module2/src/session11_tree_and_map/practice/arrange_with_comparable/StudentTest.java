package session11_tree_and_map.practice.arrange_with_comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> sList = new ArrayList<>();

        sList.add(new Student("Chuong", 32));
        sList.add(new Student("Quang", 18));
        sList.add(new Student("Hien", 22));
        sList.add(new Student("Khanh", 28));
        sList.add(new Student("Anh", 28));
        sList.add(new Student("Binh", 28));
        sList.add(new Student("Chanh", 37));

        Collections.sort(sList);

        Iterator<Student> iterator = sList.iterator();
        System.out.println("--Sort Age --");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
