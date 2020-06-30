package array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the size of array 1: ");
        int size_1 = myScanner.nextInt();
        int[] arr1 = new int[size_1];
        for(int i = 0; i < size_1; i++){
            System.out.print("Enter the value of element " + (i + 1) + ": ");
            arr1[i] = myScanner.nextInt();
        }

        System.out.print("Enter the size of array 2: ");
        int size_2 = myScanner.nextInt();
        int[] arr2 = new int[size_2];
        for(int j = 0; j < size_2; j++){
            System.out.print("Enter the value of element " + (j+1) + ": ");
            arr2[j] = myScanner.nextInt();
        }

        System.out.println("");
        System.out.print("The array 1: ");
        for(int val : arr1){
            System.out.print(val + " ");
        }

        System.out.println("");
        System.out.print("The array 2: ");
        for(int val : arr2){
            System.out.print(val + "  ");
        }
        System.out.println("");

        int size_3 = size_1 + size_2;
        int[] arr3 = new int[size_3];
        for(int i = 0; i < size_1; i++){
            arr3[i] = arr1[i];
        }
        for(int j = 0; j < size_2; j++){
            arr3[size_1+j] = arr2[j];
        }
        System.out.print("The array 3: ");
        for(int val : arr3){
            System.out.print(val + "  ");
        }
    }
}
