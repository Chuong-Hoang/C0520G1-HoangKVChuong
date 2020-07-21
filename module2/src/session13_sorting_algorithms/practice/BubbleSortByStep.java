package session13_sorting_algorithms.practice;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] list = {8,6,34,22,11};
//        System.out.println("Enter " + list.length + " values:");
//        for (int i = 0; i < list.length; i++) {
//            list[i] = myScanner.nextInt();
//        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
        System.out.println("Sort array");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        boolean needNextPass;
        for (int k = 1; k < list.length; k++) {
            needNextPass = false;
            System.out.println("Sort pass " + k);
            for (int i = 0; i < list.length - 1; i++) {
                if (list[i] > list[i+1]) {
                    System.out.println("Swap " + list[i] + " with " + list[i+1]);
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    System.out.println(Arrays.toString(list));
                    needNextPass = true;
                }
            }
            System.out.println(Arrays.toString(list));
            if(!needNextPass) break;
        }
    }
}
