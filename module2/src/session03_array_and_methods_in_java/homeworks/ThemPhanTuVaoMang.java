package session3_array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {10, 4, 6, 7, 8, 5, 3, 0, 0, 0};

        System.out.print("Enter number to be inserted: ");
        int goal = myScanner.nextInt();
        System.out.print("Choose index of " + goal + ": ");
        int index = myScanner.nextInt();

        System.out.print("Before insert " + goal + ": ");
        for(int val : arr){
            System.out.print(val + "  ");
        }
        System.out.println("");

        System.out.print("After insert " + goal + ": ");
        for(int i = arr.length -1; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = goal;
        for(int val : arr){
            System.out.print(val + "  ");
        }
    }
}
