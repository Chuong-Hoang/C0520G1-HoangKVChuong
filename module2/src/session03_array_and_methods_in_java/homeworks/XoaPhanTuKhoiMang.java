package session3_array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {4, 8, -7, 9, -3, 2, 11, 5, 22};
        int goal;
        System.out.print("Enter the number to be removed: ");
        goal = myScanner.nextInt();
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(goal == arr[i]) {
                index = i;
                break;
            }
        }
        if(index != -1){
            System.out.print("Before remove " + goal + ": ");
            for(int val : arr){
                System.out.print(val + "\t");
            }
            System.out.println("");
            System.out.print("After remove " + goal + ": ");
            for(int i = index; i < arr.length-1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = 0;
            for(int val : arr){
                System.out.print(val + "\t");
            }

        } else {
            System.out.println(goal + " not found in the array.");
        }
    }
}
