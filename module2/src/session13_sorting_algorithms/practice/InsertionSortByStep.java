package session13_sorting_algorithms.practice;

import java.util.Arrays;

public class InsertionSortByStep {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 9, 4, 12, 6, 24, 18, 37, 0, 21};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            System.out.println("Temp -->" + temp);
            int j = i-1;
            for (; j >= 0 && temp < arr[j]; j--) {
                System.out.println("swap " + arr[j+1] + " and " + arr[j]);
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
    }
}
