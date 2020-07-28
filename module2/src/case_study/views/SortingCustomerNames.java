package case_study.views;

import case_study.models.Customer;

import java.util.Comparator;

public class SortingCustomerNames implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        String lastName1 = InputData.getLastNameIndex(customer1.getName());
        String lastName2 = InputData.getLastNameIndex(customer2.getName());
        int resultName = lastName1.compareTo(lastName2);
        if(resultName == 0) {
            int birthYear1 = InputData.getBirthYear(customer1.getBirthday());
            int birthYear2 = InputData.getBirthYear(customer2.getBirthday());
            return birthYear1 - birthYear2;
        }
        return resultName;
    }
}
