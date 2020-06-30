package array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class TimPhanTuNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int size = myScanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print("Input value of the element " + (i+1) + ": ");
            arr[i] = myScanner.nextInt();
        }
        System.out.print("The array: ");
        for(int val : arr){
            System.out.print(val + "  ");
        }
        System.out.println("");

        System.out.println("Min element is at index " + findMinValue(arr));
        System.out.println("Min element: " + arr[findMinValue(arr)]);
    }

    public static int findMinValue(int[] arr){
        int min = arr[0];
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(min < arr[i]){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
