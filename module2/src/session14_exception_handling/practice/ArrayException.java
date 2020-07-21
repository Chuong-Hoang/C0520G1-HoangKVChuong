package session14_exception_handling.practice;
import java.util.Random;
import java.util.Scanner;

public class ArrayException {

    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List of array elements: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }

        return arr;
    }

    public static void main(String[] args) {
        ArrayException arrEx = new ArrayException();
        Integer[] arr = arrEx.createRandom();
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Input an index of the array: ");
        int index = sc.nextInt();
        try {
            System.out.println("Element value: " + arr[index]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index out of bound of the array.");
            e.printStackTrace();
        }
    }

}
