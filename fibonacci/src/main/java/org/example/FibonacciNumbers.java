package org.example;

import java.util.Arrays;

public class FibonacciNumbers {
    static final long[] memory = new long[100];

    public static void main(String[] args) {
        Arrays.fill(memory, -1);
        memory[0] = 0;
        memory[1] = 1;
        System.out.println(fibonacci(50));
    }

    private static long fibonacci(int n) {
        if (memory[n] != -1) {
            return memory[n];
        }

        memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memory[n];
    }
}