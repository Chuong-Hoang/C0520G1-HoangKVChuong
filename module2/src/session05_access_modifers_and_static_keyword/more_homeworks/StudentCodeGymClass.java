package session05_access_modifers_and_static_keyword.more_homeworks;

import java.util.Scanner;

public class StudentCodeGymClass {

    public static StudentCodeGym[] studentCodeGym;

    //Use static block to initialize static variable (class variable)
    static {
        StudentCodeGym st1 = new StudentCodeGym(357, "Tran Kim", "20/04/1985");
        StudentCodeGym st2 = new StudentCodeGym(222, "Nguyen Vu", "05/01/1990");
        StudentCodeGym st3 = new StudentCodeGym(333, "Le Lai", "15/12/2000");

        studentCodeGym = new StudentCodeGym[3];
        studentCodeGym[0] = st1;
        studentCodeGym[1] = st2;
        studentCodeGym[2] = st3;
    }

    public static StudentCodeGym[] getStudentCodeGymList() {
        return studentCodeGym;
    }

    public static void display(StudentCodeGym[] arrList) {
        sortAge(arrList);
        for (int i = 0; i < arrList.length; i++) {
            if (arrList[i] != null) {
                System.out.print("Student " + (i + 1) + ": ");
                System.out.print(arrList[i].getId() + " - ");
                System.out.print(arrList[i].getName() + " - ");
                System.out.println(arrList[i].getDateOfBirth());
            }
        }
        System.out.println("-----------------------------------------");
    }

    public static void register(StudentCodeGym newStudent) {
        int len = studentCodeGym.length;
        StudentCodeGym[] newStudentList = new StudentCodeGym[len + 1];
        for (int i = 0; i < len; i++) {
            newStudentList[i] = studentCodeGym[i];
        }
        newStudentList[len] = newStudent;
        studentCodeGym = newStudentList;

        System.out.println("New student named '" + getStudentCodeGymList()[len].getName() + "' has been enrolled.");
        //display(getStudentCodeGymList());
    }

    public static void graduate(int id) {
        int index = -1;
        for (int i = 0; i < studentCodeGym.length; i++) {
            if (studentCodeGym[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Really want to remove '" + studentCodeGym[index].getName() + "'?");
            System.out.print("Yes(1)? or No(0)? ");
            Scanner myScanner = new Scanner(System.in);
            int choice = myScanner.nextInt();
            if (choice == 1) {
                System.out.println("Student named '" + studentCodeGym[index].getName() + "' has graduated.");
                StudentCodeGym[] newStudentList = new StudentCodeGym[studentCodeGym.length - 1];
                for (int j = 0; j < newStudentList.length; j++) {
                    if (j < index) newStudentList[j] = studentCodeGym[j];
                    else newStudentList[j] = studentCodeGym[j + 1];
                }
                studentCodeGym = newStudentList;
            } else {
                System.out.println("No student removed!");
            }
        } else {
            System.out.println("Student width ID " + id + " not found.");
        }
        display(getStudentCodeGymList());
    }

    public static void sortAge(StudentCodeGym[] a) {
        StudentCodeGym temp;
        boolean swapped;
        for (int n = 0; n < a.length; n++) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].getId() > a[i + 1].getId()) {
                    swapped = true;
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            if (!swapped) break;
        }
    }
}
