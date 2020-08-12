package session_consolidation.io_character_exam;
import java.util.*;

public class WorkerManager {
    private List<WorkerFactory> workerFactoryList;

    //Default constructor
    public WorkerManager() {
        workerFactoryList = new ArrayList<>();
    }

    public WorkerManager(List<WorkerFactory> workerFactoryList) {
        this.workerFactoryList = workerFactoryList;
    }

    public List<WorkerFactory> getWorkerFactoryList() {
        return workerFactoryList;
    }

    public void setWorkerFactoryList(List<WorkerFactory> workerFactoryList) {
        this.workerFactoryList = workerFactoryList;
    }

    //Manipulation data
    public void addNewWorkerFactory() {
        Scanner sc = new Scanner(System.in);
        String id;
        String name;
        int age;
        int salary;
        System.out.print("Input id: ");
        id = sc.nextLine();

        System.out.print("Input name: ");
        name = sc.nextLine();

        System.out.print("Input age: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.print("Input salary: ");
        salary = Integer.parseInt(sc.nextLine());

        WorkerFactory newWorker = new WorkerFactory(id, name, age, salary);
        this.workerFactoryList.add(newWorker);
        System.out.println("New worker with Id " + id + " has been added.");
    }

    public void displayWorkerList() {
        Collections.sort(this.getWorkerFactoryList(), new SortingById());
        Iterator<WorkerFactory> iterator = this.getWorkerFactoryList().iterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next().toString());
            i++;
        }
    }

    public void deleteAWorker() {
        System.out.print("Input a worker-Id: ");
        String id = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (WorkerFactory worker : this.workerFactoryList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                this.workerFactoryList.remove(worker);
                break;
            }
        }

        if (isFound) {
            System.out.println("Worker with Id " + id + " has been removed.");
        } else {
            System.out.println("Worker Id " + id + " not found in the list...");
        }
    }

    public void updateWorkerSalary() {
        System.out.print("Input a worker-Id: ");
        String id = new Scanner(System.in).nextLine();
        boolean isFound = false;
        WorkerFactory foundWorker = null;
        for (WorkerFactory worker : this.workerFactoryList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                foundWorker = worker;
                System.out.println("Worker found: ");
                System.out.println(worker.toString());
                break;
            }
        }

        if (isFound) {
            System.out.print("Input new salary: ");
            int salary = Integer.parseInt((new Scanner(System.in)).nextLine());
            foundWorker.setSalary(salary);
            System.out.println("New update:");
            System.out.println(foundWorker.toString());
        } else {
            System.out.println("Worker Id " + id + " not found in the list...");
        }
    }
}
