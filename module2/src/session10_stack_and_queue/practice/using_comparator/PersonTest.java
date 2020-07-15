package session10_stack_and_queue.practice.using_comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class PersonTest {
    public static void main(String[] args) {

        ArrayList<Person> humanList = new ArrayList<>();
        Comparator<Person> comparatorAgeAndName = new ComparatorSortByAgeAndName();
        Comparator<Person> comparatorName = new ComparatorSortByName();
        Comparator<Person> comparatorGenderAndAge = new ComparatorSortByGenderAndAge();
        humanList.add(new Person("BBB", 32, "female"));
        humanList.add(new Person("DDD", 32, "male"));
        humanList.add(new Person("FFF", 28, "female"));
        humanList.add(new Person("CCC", 35, "female"));
        humanList.add(new Person("HHH", 22, "male"));
        humanList.add(new Person("AAA", 32, "male"));
        humanList.add(new Person("EEE", 38, "female"));

        System.out.println("-- Sort by Gender and Age --");
        Collections.sort(humanList, comparatorGenderAndAge);
        Iterator<Person> iteratorOne = humanList.iterator();
        while (iteratorOne.hasNext()) {
            System.out.println(iteratorOne.next());
        }

        System.out.println("-- Sort by Age and Name --");
        Collections.sort(humanList, comparatorAgeAndName);
        Iterator<Person> iteratorSecond = humanList.iterator();
        while (iteratorSecond.hasNext()) {
            System.out.println(iteratorSecond.next());
        }
    }
}
