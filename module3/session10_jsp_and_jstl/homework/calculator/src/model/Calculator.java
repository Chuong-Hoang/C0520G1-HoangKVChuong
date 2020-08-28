package model;

public class Calculator {

    public static double calculate(String firstOperand, String secondOperand, String operator) {
        if ("Addition".toLowerCase().equals(operator.toLowerCase())) {
            return Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
        } else if ("Subtraction".toLowerCase().equals(operator.toLowerCase())) {
            return Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
        } else if ("Multiplication".toLowerCase().equals(operator.toLowerCase())) {
            return Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
        } else if ("Division".toLowerCase().equals(operator.toLowerCase())){
            if (Double.parseDouble(secondOperand) == 0) {
                throw new ArithmeticException("Divided by zero");
            } else {
                return Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
            }
        } else {
            throw new RuntimeException("Invalid input");
        }
    }


}
