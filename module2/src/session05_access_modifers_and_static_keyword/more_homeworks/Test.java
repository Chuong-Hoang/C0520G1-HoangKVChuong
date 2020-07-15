package session5_access_modifers_and_static_keyword.more_homeworks;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("MAIN MENU");
        System.out.println("1. Display list of students");
        System.out.println("2. Register new student");
        System.out.println("3. Remove student");
        System.out.println("4. Exit");

        System.out.print("Choose your option: ");
        int opt = myScanner.nextInt();
        switch (opt) {
            case 1:
                //Display list of students
                StudentCodeGymClass.display(StudentCodeGymClass.getStudentCodeGymList());
                mainMenu();
                break;
            case 2:
                //Input student information
                System.out.print("How many students to be enrolled? ");
                int n = myScanner.nextInt();
                StudentCodeGym newStudent;
                for (int i = 0; i < n; i++) {
                    System.out.println("Information of Student " + (i + 1));
                    System.out.print("ID: ");
                    int id = myScanner.nextInt();
                    myScanner.nextLine();

                    System.out.print("Name: ");
                    String name = myScanner.nextLine();

                    System.out.print("Birthday: ");
                    String birthday = myScanner.nextLine();
                    newStudent = new StudentCodeGym(id, name, birthday);
                    StudentCodeGymClass.register(newStudent);
                }
                StudentCodeGymClass.display(StudentCodeGymClass.getStudentCodeGymList());
                mainMenu();
                break;
            case 3:
                //Remove graduate student
                System.out.print("Input ID to be removed: ");
                int id = myScanner.nextInt();
                StudentCodeGymClass.graduate(id);
                mainMenu();
                break;
            case 4:
                //Exit the program
                System.exit(0);
            default:
                System.out.println("No option chosen!");
                mainMenu();
        }
    }
}
