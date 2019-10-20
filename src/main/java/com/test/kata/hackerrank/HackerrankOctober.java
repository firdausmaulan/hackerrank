package com.test.kata.hackerrank;

public final class HackerrankOctober {

    private HackerrankOctober() {}

    public static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        int temp = 0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[j] == i + 1) {
                    temp = j + 1;
                    break;
                }
            }
            for (int k = 0; k < p.length; k++) {
                if (p[k] == temp) {
                    result[i] = k + 1;
                    break;
                }
            }
        }
        return result;
    }
}