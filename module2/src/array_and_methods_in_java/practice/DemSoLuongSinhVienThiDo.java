package array_and_methods_in_java.thuc_hanh;
import java.util.Scanner;

public class DemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int sum;
        do {
            System.out.print("Input the quantity of student: ");
            sum = myScanner.nextInt();
        } while (sum <= 0 || sum > 30);
        double[] studentMark = new double[sum];
        int count = 0;
        for(int i = 0; i < sum; i++){
            System.out.print("Input mark of student " + (i+1) + ": ");
            studentMark[i] = myScanner.nextDouble();
            if(studentMark[i] >= 5) count++;
        }
        System.out.print("Mark of Students: ");
        for(double x : studentMark){
            System.out.print(x + "  ");
        }
        System.out.println("");
        System.out.println("There are " + count + " students that pass the exam.");


    }
}
