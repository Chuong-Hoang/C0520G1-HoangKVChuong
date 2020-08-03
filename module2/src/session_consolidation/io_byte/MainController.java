package session_consolidation.io_byte;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        showMainMenu();
    }
    public static void showMainMenu() {
        StudentManager studentManager = new StudentManager();
        studentManager.setStudentList(StudentUtility.readStudentFile());
        System.out.println("_________Main Menu________");
        System.out.println("1.Add new student");
        System.out.println("2.Display student list");
        System.out.println("3.Delete a student");
        System.out.println("4.Exit");
        System.out.println("__________________________");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (option) {
            case 1:
                //Add new student
                studentManager.addNewStudent();
                System.out.print("Do you want to save modification? Yes(1) / No(0)? ");
                int choose = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choose == 1) {
                    StudentUtility.writeStudentFile(studentManager.getStudentList());
                }
                break;
            case 2:
                //Display all students
                studentManager.displayStudentList();
                break;
            case 3:
                //Delete a student
                studentManager.deleteAStudent();
                System.out.print("Do you want to save modification? Yes(1) / No(0)? ");
                choose = Integer.parseInt(new Scanner(System.in).nextLine());
                if (choose == 1) {
                    StudentUtility.writeStudentFile(studentManager.getStudentList());
                }
                break;
            case 4:
                System.exit(0);
        }

        System.out.println("....................................");
        showMainMenu();
    }
}
