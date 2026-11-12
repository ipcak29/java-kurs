package org.example;

public enum OperationType {
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", OperationType::division);


    private final String symbol;
    private final MathOperation operation;

    OperationType(String simbol, MathOperation operation) {
        this.symbol = simbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public MathOperation getOperation() {
        return operation;
    }

    public static OperationType fromSymbol(String symbol) {
        for (OperationType type : values()) {
            if (symbol.equals(type.getSymbol())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Nieznany symbol: " + symbol);
    }
    private static int division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Nie można dzielić przez zero");
        }
        return a / b;
    }
}
