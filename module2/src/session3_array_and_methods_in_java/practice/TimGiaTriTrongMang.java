package session3_array_and_methods_in_java.thuc_hanh;
import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String[] studentList = {"Chuong", "Quang", "Nhat", "Minh", "Toan", "Mai", "Nhung"};
        for(String st : studentList){
            System.out.print(st + " ");
        }
        System.out.println("");
        boolean isExist = false;
        String goal;
        int index = -1;
        System.out.print("Enter the name to be seeked: ");
        goal = myScanner.nextLine();
        for(int i = 0; i < studentList.length; i++){
            if(studentList[i].equals(goal)) {
                isExist = true;
                index = i;
                break;
            }
        }
        if(isExist){
            System.out.println("'" + goal + "'" + " is at index " + index);
        } else {
            System.out.println("'" + goal + "'" + " is not in the student list.");
        }
    }
}
