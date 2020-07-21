package session13_sorting_algorithms.practice;

import java.util.Arrays;

public class SelectionSortByStep {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 5, 7, 3, 12, 8, 19, 23, 1, 26, 34, 0, 6};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length-1; i++) {
            int min = arr[i];
            int index = -1;
            for (int j = i; j < arr.length; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != -1) {
                System.out.println("swap " + arr[i] + " and " + arr[index] );
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
