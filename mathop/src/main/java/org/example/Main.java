package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(execute(10, 2, OperationType.ADD.getOperation()));
        System.out.println(execute(10, 2, OperationType.DIVISION.getOperation()));
        System.out.println(execute(10, 2, OperationType.MULTIPLY.getOperation()));

        try {
            System.out.println(execute(10, 0, OperationType.fromSymbol("/").getOperation()));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int execute(int a, int b, MathOperation operation) {
        return operation.calculate(a, b);
    }
}