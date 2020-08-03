package session_consolidation.io_byte;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public StudentManager(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /* Manipulation data here....*/

    //Add new student
    public void addNewStudent() {
        Scanner sc = new Scanner(System.in);
        String id;
        String name;
        String address;
        int totalFee;
        Student newStudent;
        System.out.print("Input Id: ");
        id = sc.nextLine();

        System.out.print("Input Name: ");
        name = sc.nextLine();

        System.out.print("Input Address: ");
        address = sc.nextLine();

        System.out.print("Input total_fee: ");
        totalFee = Integer.parseInt(sc.nextLine());

        newStudent = new Student(id, name, address, totalFee);

        this.studentList.add(newStudent);

        System.out.println("New student name '" + name + "' has been added.");
    }

    public void displayStudentList() {
        int i = 1;
        System.out.println("_____Students List_____");
        for (Student student : this.getStudentList()) {
            System.out.println(i + ". " + student.toString());
            i++;
        }
        System.out.println("_____End List_____");
    }

    public void deleteAStudent() {
        System.out.print("Input Student Id: ");
        String id = new Scanner(System.in).nextLine();
        boolean isFound = false;
        Student foundStudent = null;
        for (Student student : this.getStudentList()) {
            if(id.compareTo(student.getId()) == 0) {
                isFound = true;
                foundStudent = student;
                System.out.println("Student found:");
                System.out.println(foundStudent.toString());
                break;
            }
        }

        if (isFound) {
            System.out.print("Delete student name " + foundStudent.getName() + "? Yes(1) / No(0)? ");
            int option = Integer.parseInt(new Scanner(System.in).nextLine());
            if(option == 1) {
                this.getStudentList().remove(foundStudent);
                System.out.println("Student name ''" + foundStudent.getName() + "'' has been deleted.");
            } else {
                System.out.println("No student deleted!");
            }
        } else {
            System.out.println("Student Id" + id + " not found in the list.");
        }
    }


}
