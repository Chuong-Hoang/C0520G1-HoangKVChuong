package session11_tree_and_map.practice.arrange_with_comparator;
import java.util.Comparator;

public class ComparatorSortByAge implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        int resultAge = s1.getAge() - s2.getAge();
        if(resultAge == 0) {
            return s1.getName().compareTo(s2.getName());
        }
        return resultAge;
    }

}
