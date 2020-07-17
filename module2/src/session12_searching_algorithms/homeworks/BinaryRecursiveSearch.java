package session12_searching_algorithms.homeworks;

public class BinaryRecursiveSearch {
    public static void main(String[] args) {
        int[] array = {2, 4, 5, 7 , 9, 14, 17, 28, 39, 44, 59, 61, 77};
        int x = 44;
        int low = 0;
        int high = array.length - 1;
        System.out.println("Binary Search Result: " + binaryRecursiveSearch(array, low, high, x));
    }

    public static int binaryRecursiveSearch(int[] arr, int low, int high, int x) {
        if(high >= low) {
            int mid = (high + low)/2;
            if (x == arr[mid])
                return mid;
            else if (x < arr[mid]) {
                high = mid - 1;
                return binaryRecursiveSearch(arr, low, high, x);
            } else {
                low = mid + 1;
                return binaryRecursiveSearch(arr, low, high, x);
            }
        }
       return -1;
    }
}
