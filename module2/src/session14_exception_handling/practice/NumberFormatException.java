package session14_exception_handling.practice;

import demo.file_writer_and_reader.CsvObjectOutput;

import java.util.Scanner;

public class NumberFormatException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x: ");
        int x = sc.nextInt();
        System.out.print("Input y: ");
        int y = sc.nextInt();

        NumberFormatException numEx = new NumberFormatException();
        numEx.calculate(x, y);
    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x/y;

            System.out.println("Addition x + y = " + a);
            System.out.println("Subtraction x - y = " + b);
            System.out.println("Multiplication x * y = " + c);
            System.out.println("Division x / y = " + d);
        } catch (Exception e) {
            System.err.println("An exception happens: " + e);
        }
    }
}
