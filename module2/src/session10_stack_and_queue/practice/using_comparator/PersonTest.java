package session10_stack_and_queue.practice.using_comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonTest {
    public static void main(String[] args) {
        ArrayList<Person> humanList = new ArrayList<>();
        Comparator<Person> comparatorAge = new ComparatorSortByAge();
        Comparator<Person> comparatorName = new ComparatorSortByName();
        humanList.add(new Person("BBB", 32, "female"));
        humanList.add(new Person("DDD", 30, "male"));
        humanList.add(new Person("FFF", 28, "female"));
        humanList.add(new Person("CCC", 35, "female"));
        humanList.add(new Person("HHH", 22, "male"));
        humanList.add(new Person("AAA", 31, "male"));
        humanList.add(new Person("EEE", 38, "female"));

        Collections.sort(humanList, comparatorAge);
        System.out.println("-- Sort by Age --");
        for(Person p : humanList) {
            System.out.println(p);
        }
        System.out.println();

        Collections.sort(humanList, comparatorName);
        System.out.println("-- Sort by Name --");
        for(Person p : humanList) {
            System.out.println(p);
        }

    }
}
