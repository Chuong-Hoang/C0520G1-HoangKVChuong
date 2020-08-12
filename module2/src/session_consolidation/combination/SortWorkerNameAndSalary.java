package session_consolidation.combination;

import java.util.Comparator;

public class SortWorkerNameAndSalary implements Comparator<Worker> {

    @Override
    public int compare(Worker w1, Worker w2) {
        String name1 = w1.getName();
        String name2 = w2.getName();
        int nameResult = WorkerManager.getLastName(name1).compareTo(WorkerManager.getLastName(name2));
        if(nameResult == 0) {
            return w1.getSalary() - w2.getSalary();
        }
        return nameResult;
    }
}
