package session10_stack_and_queue.practice.using_comparator;

import java.util.Comparator;

public class ComparatorSortByGender implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
          return p1.getGender().compareTo(p2.getGender());
    }
}
