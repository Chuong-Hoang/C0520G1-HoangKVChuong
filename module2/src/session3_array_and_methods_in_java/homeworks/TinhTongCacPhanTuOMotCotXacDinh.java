package session3_array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class TinhTongCacPhanTuOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int row, col;
        System.out.print("Input the size of array: ");
        row = myScanner.nextInt();
        System.out.print("Input the size of each row: ");
        col = myScanner.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print("Input element row " + (i+1) + " column " + (j+1) + ": ");
                arr[i][j] = myScanner.nextInt();
            }
        }
        System.out.println("The array: ");
        for(int i = 0; i < row; i++){
            for(int val : arr[i]){
                System.out.print(val + "  ");
            }
            System.out.println("");
        }
        System.out.print("Input the column to be totally calculated: ");
        int index = myScanner.nextInt();
        int sum = 0;
        for(int i = 0; i < row; i++){
            sum += arr[i][index-1];
        }
        System.out.println("The value totality of column " + index + " is " + sum);
    }
}
