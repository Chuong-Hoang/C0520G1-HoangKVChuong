package session10_stack_and_queue.practice.using_comparator;

import java.util.Comparator;

public class ComparatorSortByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
