package session14_exception_handling.homeworks;

public class IllegalTriangleException extends Exception {
    IllegalTriangleException(String s) {
        super(s);
    }

    IllegalTriangleException() {
        super("Some error!");
    }
}
