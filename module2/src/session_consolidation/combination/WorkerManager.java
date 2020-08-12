package session_consolidation.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkerManager {
    private List<Worker> workerList;

    public WorkerManager() {
        workerList = new ArrayList<>();
    }

    public WorkerManager(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    /* ______________________ MANIPULATION OF DATA ___________________________ */

    Scanner sc = new Scanner(System.in);
    public void addNewCustomer() {
        System.out.print("Enter worker Id: ");
        String id = sc.nextLine();
        boolean isFound = false;
        for (Worker worker : workerList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter birthday: ");
            String birthday = sc.nextLine();

            System.out.print("Enter salary: ");
            int salary = Integer.parseInt(sc.nextLine());

            Worker newWorker = new Worker(id, name, birthday, salary);
            this.workerList.add(newWorker);
            System.out.println("Worker name '" + name + "' has been added into the list.");

        } else {
            System.out.println("The worker with id '" + id + "' is already in the list. Please put another id.");
        }
    }

    public void deleteAWorker(){
        System.out.print("Enter worker Id: ");
        String id = sc.nextLine();
        boolean isFound = false;
        Worker removedWorker = null;
        for (Worker worker : workerList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                removedWorker = worker;
                break;
            }
        }
        if(!isFound) {
            System.out.println("The worker with id '" + id + "' not found in the list.");
        } else {
            System.out.print("Delete the worker with id '" + id + "'? Yes(1) or No(0)? ");
            if(Integer.parseInt(sc.nextLine()) == 1) {
                workerList.remove(removedWorker);
                System.out.println("The worker with id '" + id + "' removed from the list.");
            } else {
                System.out.println("No worker removed at all.");
            }
        }
    }

    public void displayWorkerList(){
        System.out.println("__________________________________Workers List______________________________________");
        int i = 1;
        for (Worker worker : workerList) {
            System.out.println(i + ". " + worker.toString());
            i++;
        }
    }

    public void editWorkerName() {
        System.out.print("Enter worker Id: ");
        String id = sc.nextLine();
        boolean isFound = false;
        Worker editedWorker = null;
        for (Worker worker : workerList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                editedWorker = worker;
                break;
            }
        }
        if(!isFound) {
            System.out.println("The worker with id '" + id + "' not found in the list.");
        } else {
            System.out.println("Worker info:");
            System.out.println(editedWorker.toString());
            System.out.print("Input new name: ");
            String newName = sc.nextLine();
            editedWorker.setName(newName);
            System.out.println("After update name: ");
            System.out.println(editedWorker.toString());
        }
    }

    public void editWorkerSalary() {
        System.out.print("Enter worker Id: ");
        String id = sc.nextLine();
        boolean isFound = false;
        Worker editedWorker = null;
        for (Worker worker : workerList) {
            if (id.compareTo(worker.getId()) == 0) {
                isFound = true;
                editedWorker = worker;
                break;
            }
        }
        if(!isFound) {
            System.out.println("The worker with id '" + id + "' not found in the list.");
        } else {
            System.out.println("Worker info:");
            System.out.println(editedWorker.toString());
            System.out.print("Input new salary: ");
            int newSalary = Integer.parseInt(sc.nextLine());
            editedWorker.setSalary(newSalary);
            System.out.println("After update name: ");
            System.out.println(editedWorker.toString());
        }
    }

    public void findRelativeName() {
        List<Worker> workerListResult = new ArrayList<>();
        System.out.print("Input the first character of name: ");
        String firstChar = sc.nextLine().toLowerCase();
        for(Worker worker : workerList) {
            if(worker.getName().toLowerCase().contains(firstChar)) {
                workerListResult.add(worker);
            }
        }

        int i = 1;
        if(workerListResult.isEmpty()){
            System.out.println("No worker found in the list.");
        } else {
            System.out.println("Result found:");
            for (Worker worker : workerListResult) {
                System.out.println(i + ". " + worker.toString());
                i++;
            }
        }
    }

    public void findAbsoluteName() {
        System.out.print("Input the name: ");
        String name = sc.nextLine().toLowerCase();
        System.out.println("The result:");
        boolean isFound = false;
        for(Worker worker : workerList) {
            if(name.equals(worker.getName().toLowerCase())) {
                isFound = true;
                System.out.println(worker.toString());
            }
        }

        if(!isFound) {
            System.out.println("No worker with name '" + name + "' found.");
        }
    }

    public static String getLastName(String name) {
        int lastSpaceIndex = name.lastIndexOf(" ");
        int lastNameIndex = lastSpaceIndex + 1;
        return name.substring(lastNameIndex);
    }
}
