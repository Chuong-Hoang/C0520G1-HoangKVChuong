package session12_searching_algorithms.demo;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 80, 30, 60, 50, 110, 100, 130, 170};
        int x = -170;
        System.out.println("Result: " + linearSearch(arr, x));

    }

    public static int linearSearch(int arr[], int x) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (x == arr[i])
                return i;
        }
        return -1;
    }
}
