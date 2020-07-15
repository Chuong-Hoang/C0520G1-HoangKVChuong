package session3_array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class TongCacPhanTuODuongCheoChinhMaTranVuong {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int size;
        System.out.print("Input the size of the square matrix: ");
        size = myScanner.nextInt();
        int[][] arr = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print("Input element at row " + (i+1) + " column " + (j+1) + ": ");
                arr[i][j] = myScanner.nextInt();
            }
        }
        System.out.println("The square matrix:");
        for(int[] val: arr){
            for(int x : val){
                System.out.print(x + "  ");
            }
            System.out.println("");
        }

        int sum = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(i == j) sum += arr[i][j];
            }
        }
        System.out.println("Totality of elements on the main brace: " + sum);
    }
}
