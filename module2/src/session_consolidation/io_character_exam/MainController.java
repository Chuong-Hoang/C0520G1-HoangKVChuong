package session_consolidation.io_character_exam;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        WorkerManager workerManager = new WorkerManager();
        workerManager.setWorkerFactoryList(WorkerUtility.readWorkerFile());
        System.out.println("[1].Add new worker");
        System.out.println("[2].Update worker salary");
        System.out.println("[3].Delete a worker");
        System.out.println("[4].Display workers list");
        System.out.println("[5].Exit");
        System.out.println("_______________________");
        System.out.print("Select an option: ");
        int opt = Integer.parseInt((new Scanner(System.in).nextLine()));
        switch (opt) {
            case 1:
                //Add new worker
                workerManager.addNewWorkerFactory();
                WorkerUtility.writeWorkerFile(workerManager.getWorkerFactoryList());
                break;
            case 2:
                //Update worker salary
                workerManager.updateWorkerSalary();
                WorkerUtility.writeWorkerFile(workerManager.getWorkerFactoryList());
                break;
            case 3:
                //Delete a worker
                workerManager.deleteAWorker();
                WorkerUtility.writeWorkerFile(workerManager.getWorkerFactoryList());
                break;
            case 4:
                //Display worker list
                workerManager.displayWorkerList();
                break;
            case 5:
                System.exit(0);
        }
        System.out.println("_______________________");
        showMainMenu();
    }
}
