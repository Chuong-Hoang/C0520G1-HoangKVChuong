package session3_array_and_methods_in_java.bai_tap;
import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int row, col;
        System.out.print("Enter the size of the 2D array: ");
        row = myScanner.nextInt();
        System.out.print("Enter the size of each row: ");
        col = myScanner.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print("Input the value of element at row " + (i+1) + " and column " + (j+1) + ": ");
                arr[i][j] = myScanner.nextInt();
            }
        }
        System.out.println("The 2D array: ");
        for(int i = 0; i < row; i++){
            for(int val: arr[i]){
                System.out.print(val + "  ");
            }
            System.out.println("");
        }
        int max = arr[0][0];
        int indexRow = -1, indexCol = -1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(max < arr[i][j]){
                    max = arr[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.print("The max element is: " + max);
        System.out.println(" at the row " + (indexRow+1) + " and the column " + (indexCol+1));
    }
}
