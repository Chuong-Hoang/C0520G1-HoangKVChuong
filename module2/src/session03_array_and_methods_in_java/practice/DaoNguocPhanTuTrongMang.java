package session03_array_and_methods_in_java.thuc_hanh;

import java.util.Scanner;

public class DaoNguocPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int number = 0;
        while (number <= 0 || number > 20) {
            System.out.print("Enter the length of array: ");
            number = myScanner.nextInt();
        }

        int[] myArr = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Input a value for element " + (i + 1) + ": ");
            myArr[i] = myScanner.nextInt();
        }
        for (int val : myArr) {
            System.out.print(val + "\t");
        }
        System.out.println("");
        for (int j = 0; j < number / 2; j++) {
            int temp = myArr[j];
            myArr[j] = myArr[number - 1 - j];
            myArr[number - 1 - j] = temp;
        }
        for (int val : myArr) {
            System.out.print(val + "\t");
        }
    }
}
