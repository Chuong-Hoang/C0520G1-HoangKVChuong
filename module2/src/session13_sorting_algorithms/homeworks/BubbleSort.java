package session13_sorting_algorithms.homeworks;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {12,1,5,2,7,25,14, 17, 36, 14, 11, 9, 28, 0};
        System.out.print("Your input list: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        System.out.println("Sort array");
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] list) {
        boolean swapped;
        for (int k = 1; k < list.length; k++) {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i+1]) {
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(list));
            if(!swapped) break;
        }
    }
}
