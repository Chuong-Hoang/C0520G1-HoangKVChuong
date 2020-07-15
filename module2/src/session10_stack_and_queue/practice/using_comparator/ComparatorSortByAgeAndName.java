package session10_stack_and_queue.practice.using_comparator;
import java.util.Comparator;

public class ComparatorSortByAgeAndName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int result = p1.getAge() - p2.getAge();
        if(result == 0) {
            return p1.getName().compareTo(p2.getName());
        }
        return result;
    }
}
