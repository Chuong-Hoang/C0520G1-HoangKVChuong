package array_and_methods_in_java.thuc_hanh;
import java.util.Scanner;

public class TimGTNNTrongMangDungMethod {
    public static void main(String[] args) {
        int[] a = {3, 4, 8, 9, 12, -14, 2, 0, 5};
        findMinValue(a);
    }
    public static void findMinValue(int[] arr){
        int min = arr[0];
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("Min value is " + min + " at index " + index);
    }
}
