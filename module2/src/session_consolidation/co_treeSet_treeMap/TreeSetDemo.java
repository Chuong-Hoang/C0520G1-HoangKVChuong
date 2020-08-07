package session_consolidation.co_treeSet_treeMap;

import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> studentSet = new TreeSet<>();

        Student st1 = new Student("111", "Hien", "Phu Yen", 28);
        Student st2 = new Student("222", "Nhat", "QT", 22);
        Student st3 = new Student("333", "Toan", "DN", 29);
        Student st4 = new Student("444", "Hien", "Phu Yen", 28);
        Student st5 = new Student("555", "Quang", "DN", 27);
        Student st6 = new Student("666", "Hien", "Phu Yen", 28);
        Student st7 = new Student("777", "Chuong", "QT", 28);

        studentSet.add(st1);
        studentSet.add(st2);
        studentSet.add(st3);
        studentSet.add(st4);
        studentSet.add(st5);
        studentSet.add(st6);
        studentSet.add(st7);

        System.out.println("TREE_SET");
        System.out.println("@Override compareTo() in Collections.");
        int i = 1;
        for (Student st : studentSet) {
            System.out.println(i + ". " + st.toString());
            i++;
        }

        System.out.println("___________________________________________________");
        System.out.print("Select a student: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        List<Student> studentList = new ArrayList<>(studentSet);

        System.out.println("Show ArrayList here:");
        for(i = 1; i <= studentList.size(); i++) {
            System.out.println(i +". " + studentList.get(i-1).toString());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("You chose student:");
        System.out.println(studentList.get(index).toString());
    }

}
