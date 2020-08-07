package session_consolidation.co_hashSet_hashMap;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {

        Set<Employee> employeeSet = new HashSet<>();

        Employee e1 = new Employee("E001", "Chuong", "Manager", 8000);
        Employee e2 = new Employee("E001", "Quan", "Director", 10000);
        Employee e3 = new Employee("E003", "An", "Leader", 7000);
        Employee e4 = new Employee("E004", "Tuan", "CEO", 12000);
        Employee e5 = new Employee("E005", "Phap", "Clerk", 5000);

        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);

        //Show employee set with sorting
        List<Employee> employeeList = new ArrayList<>(employeeSet);

        employeeList.sort(new SortEmployeeId());
        // this is equivalent to: Collections.sort(employeeList, new SortEmployeeId());

        Iterator<Employee> iterator = employeeList.iterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next().toString());
            i++;
        }
    }
}
