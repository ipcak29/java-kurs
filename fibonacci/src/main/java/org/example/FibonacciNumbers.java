package org.example;

import java.util.Arrays;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Arrays.fill(memory, -1);
        System.out.println(fibonacci(50));
    }

    static final int[] memory = new int[100];

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memory[n] != -1) {
            return memory[n];
        }

        memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return memory[n];
    }
}