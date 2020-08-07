package james_case_study;
import java.util.Scanner;

public class Controller {
    //This class is used for receive/read request
    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        Scanner sc = new Scanner(System.in);
        EntityManager entityManager = new EntityManager();


        System.out.println("____ MAIN MENU ____");
        System.out.println("1.Lookup a word");
        System.out.println("2.Define new word");
        System.out.println("3.Drop a word");
        System.out.println("4.Exit program");
        System.out.println("____________________");

        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());

        entityManager.setEntityTreeMap(ReaderAndWriter.readFile());

        switch(option) {
            case 1:
                //Lookup a word
                entityManager.findEntity();
                ReaderAndWriter.writeFile(entityManager.getEntityTreeMap());
                break;
            case 2:
                //Define new word
                entityManager.addNewEntity();
                ReaderAndWriter.writeFile(entityManager.getEntityTreeMap());
                break;
            case 3:
                //Drop a word
                entityManager.removeEntity();
                ReaderAndWriter.writeFile(entityManager.getEntityTreeMap());
                break;
            case 4:
                //Exit program
                System.out.println("*** Program ends ***");
                System.exit(0);
            default:
                //No option selected
                System.out.println("No option selected at all. Program ends here.");
        }

        System.out.println();
        showMainMenu();
    }
}
