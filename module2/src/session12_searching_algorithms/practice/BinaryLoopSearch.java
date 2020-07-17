package session12_searching_algorithms.practice;

public class BinaryLoopSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 11, 22, 25, 34, 39, 45, 59, 68};
        int x = 45;
        System.out.println("Binary Loop Search: ");
        System.out.print(binaryLoopSearch(arr, x));

    }

    public static int binaryLoopSearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (x == arr[mid])
                return mid;
            else if (x < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
