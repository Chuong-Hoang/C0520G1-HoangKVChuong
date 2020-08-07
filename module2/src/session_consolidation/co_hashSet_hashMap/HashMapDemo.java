package session_consolidation.co_hashSet_hashMap;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Employee, String> employeeMap = new HashMap<>();

        Employee e1 = new Employee("E001", "Chuong", "Manager", 10000);
        Employee e2 = new Employee("E002", "Quan", "Director", 10000);
        Employee e3 = new Employee("E003", "An", "Leader", 7000);
        Employee e4 = new Employee("E004", "Quan", "CEO", 12000);
        Employee e5 = new Employee("E005", "Phap", "Clerk", 5000);
        Employee e6 = new Employee("E006", "Duc", "Clerk", 5000);
        Employee e7 = new Employee("E007", "Nhat", "Clerk", 5000);

        employeeMap.put(e1, e1.getId());
        employeeMap.put(e2, e2.getId());
        employeeMap.put(e3, e3.getId());
        employeeMap.put(e4, e4.getId());
        employeeMap.put(e5, e5.getId());
        employeeMap.put(e6, e6.getId());
        employeeMap.put(e7, e7.getId());


        //display map
        System.out.println("Display HashMap with Iterator [______ListIterator used for List only______]");
        Iterator<String> iterator = employeeMap.values().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() );
        }

        Iterator<Employee> iterator1 = employeeMap.keySet().iterator();
        Employee e;
        while (iterator1.hasNext()) {
            e = iterator1.next();
            System.out.println(e.toString() + " --> "+ employeeMap.get(e));
        }
    }
}
