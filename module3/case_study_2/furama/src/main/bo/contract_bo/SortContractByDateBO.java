package main.bo.contract_bo;

import main.model.contract_model.Contract;

import java.util.Comparator;

public class SortContractByDateBO implements Comparator<Contract> {
    @Override
    public int compare(Contract o1, Contract o2) {
        int year1 = Integer.parseInt(o1.getContractStartDate().substring(0, 4));
        int year2 = Integer.parseInt(o2.getContractStartDate().substring(0, 4));
        int month1 = Integer.parseInt(o1.getContractStartDate().substring(5, 7));
        int month2 = Integer.parseInt(o2.getContractStartDate().substring(5, 7));
        int day1 = Integer.parseInt(o1.getContractStartDate().substring(8));
        int day2 = Integer.parseInt(o2.getContractStartDate().substring(8));
        int yearResult = year1 - year2;
        if (yearResult == 0) {
            int monthResult = month1-month2;
            if (monthResult == 0) {
                return day1-day2;
            }
            return monthResult;
        }
        return yearResult;
    }
}
