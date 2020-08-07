package session_consolidation.co_hashSet_hashMap;

import java.util.Comparator;

public class SortEmployeeId implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getId().compareTo(e2.getId());
    }
}
