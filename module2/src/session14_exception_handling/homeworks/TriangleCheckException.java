package session14_exception_handling.homeworks;
import java.lang.Exception;
import java.util.Scanner;

public class TriangleCheckException {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input first length: ");
        double x = sc.nextDouble();
        if(x < 0) throw new IllegalTriangleException("First length x not valid!");

        System.out.print("Input second length: ");
        double y = sc.nextDouble();
        if(y < 0) throw new IllegalTriangleException("Second length y not valid!");
        System.out.print("Input third length: ");
        double z = sc.nextDouble();
        if(z < 0) throw new IllegalTriangleException("Third length z not valid!");
        if(x + y <= z || x + z <= y || y + z <= x)
            throw new IllegalTriangleException("Cannot be a triangle!");
    }

}

class IllegalTriangleException extends Exception {
    IllegalTriangleException(String s) {
        super(s);
    }

    IllegalTriangleException() {
        super("Some error!");
    }
}
