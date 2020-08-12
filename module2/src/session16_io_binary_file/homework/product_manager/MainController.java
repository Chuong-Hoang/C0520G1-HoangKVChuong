package session16_io_binary_file.homework.product_manager;

import session_consolidation.combination.ReaderAndWriter;
import session_consolidation.combination.SortWorkerNameAndSalary;
import session_consolidation.combination.WorkerManager;

import java.util.Collections;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("__________MAIN MENU___________");
        System.out.println("1.Add new worker");
        System.out.println("2.Delete a worker");
        System.out.println("3.Show all workers");
        System.out.println("4.Update worker's name");
        System.out.println("5.Update worker's salary");
        System.out.println("6.Find relative name");
        System.out.println("7.Find absolute name");
        System.out.println("8.Sorting Ascending Salary");
        System.out.println("9.Exit");
        System.out.println("_______________________________");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());
        WorkerManager workerManager = new WorkerManager();
        workerManager.setWorkerList(ReaderAndWriter.readWorkerFile());
        switch (option) {
            case 1:
                //add new worker
                workerManager.addNewCustomer();
                break;
            case 2:
                //delete a worker
                workerManager.deleteAWorker();
                break;
            case 3:
                //show all workers
                workerManager.getWorkerList().sort(new SortWorkerNameAndSalary());
                workerManager.displayWorkerList();
                break;
            case 4:
                //update worker name
                workerManager.editWorkerName();
                break;
            case 5:
                //update worker salary
                workerManager.editWorkerSalary();
                break;
            case 6:
                //Find relative name
                workerManager.findRelativeName();
                break;
            case 7:
                //Find absolute name
                workerManager.findAbsoluteName();
                break;
            case 8:
                //Sorting ascending salary
                Collections.sort(workerManager.getWorkerList());
                workerManager.displayWorkerList();
                break;
            case 9:
            default:
                System.exit(0);
                break;
        }
        ReaderAndWriter.writeWorkerFile(workerManager.getWorkerList());

        System.out.println();
        showMainMenu();
    }
}
