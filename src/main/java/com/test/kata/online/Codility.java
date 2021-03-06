package com.test.kata.online;

import java.util.*;
import java.util.stream.Collectors;

public final class Codility {

    private Codility() {}

    public static int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        if (!binary.contains("0") || frequency('1', binary) <= 1) {
            return 0;
        } else {
            int count = 0;
            int max = Integer.MIN_VALUE;
            binary = binary.substring(0, binary.lastIndexOf('1'));
            for (char c : binary.toCharArray()) {
                if (c == '0') {
                    count++;
                } else {
                    count = 0;
                }
                if (count > max) {
                    max = count;
                }
            }
            return max;
        }
    }

    public static int frequency(char searchChar, String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == searchChar) {
                count++;
            }
        }
        return count;
    }

    public static int oddOccurrencesInArray(int[] a) {
        HashSet<Integer> duplicates = new HashSet<>();
        int element = -1;
        for (int n : a) {
            if (duplicates.add(n)) {
                element = n;
            }
        }
        return element;
    }


    public static int smallestInteger(int[] arr) {
        List<Integer> integers = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        return integers.get(0);
    }

    public static int armyRanks(int[] ranks) {
        int count = 0;
        List<Integer> integers = Arrays.stream(ranks).boxed().collect(Collectors.toList());
        HashSet<Integer> integerSet = new HashSet<>(integers);
        for (int n : integerSet) {
            if (integers.contains(n)) {
                count += Collections.frequency(integers, n - 1);
            }
        }
        return count;
    }

    public static String stringCodility(int A, int B) {
        String result = "";
        String a = "a";
        String b = "b";
        if (A > B && A - B <= 3) {
            return minLessThanTwo(A, B, a, b);
        } else if (B > A && B - A <= 3) {
            return minLessThanTwo(B, A, b, a);
        } else if (A > B) {
            return moreThanString(A, B, a, b);
        } else if (B > A) {
            return moreThanString(B, A, b, a);
        } else {
            for (int i = 0; i < A + B; i++) {
                if (i % 2 == 0) {
                    result = result.concat(a);
                } else {
                    result = result.concat(b);
                }
            }
            return result;
        }
    }

    private static String minLessThanTwo(int x, int y, String xS, String yS) {
        String result = "";
        int countX = 0;
        for (int i = 0; i < y * 2; i++) {
            if (i % 2 == 0) {
                result = result.concat(xS);
                countX++;
            } else {
                result = result.concat(yS);
            }
        }
        return countSpare(result, xS, countX, x);
    }

    private static String moreThanString(int x, int y, String xS, String yS) {
        String result = "";
        int count = 0;
        int countY = 0;
        int i = 0;
        while (i < x) {
            if (count > 1) {
                result = result.concat(yS);
                countY++;
                count = 0;
            } else {
                result = result.concat(xS);
                count++;
                i++;
            }
        }
        return countSpare(result, yS, countY, y);
    }

    private static String countSpare(String result, String s, int count, int actual) {
        if (count < actual) {
            for (int i = 0; i < actual - count; i++) {
                if (i > 1) {
                    result = s.concat(result);
                } else {
                    result = result.concat(s);
                }
            }
        }
        return result;
    }

    public static int gamble(int N, int K) {
        int rounds = 0;
        if (K == 0) {
            return N - 1;
        } else {
            int count = 0;
            int i = 0;
            while (N > 1) {
                if (i % 2 == 0 && count < K) {
                    N = N / 2;
                    rounds++;
                    count++;
                } else {
                    N -= 1;
                    rounds++;
                }
                i++;
            }
            return rounds;
        }
    }

    public static String reversed(String s) {
        String[] arr = s.split(" ");
        List<String> strings = new ArrayList<>();
        for (String single : arr) {
            StringBuilder builder =  new StringBuilder();
            for (int i = single.length() - 1; i >= 0; i--) {
                builder.append(single.toCharArray()[i]);
            }
            strings.add(builder.toString());
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string).append(" ");
        }
        return builder.toString().trim();
    }

    public static int longestPath(Tree tree) {
        int leftSum = countPath(tree.l);
        int rightSum = countPath(tree.r);
        return Math.max(leftSum, rightSum);
    }

    private static int countPath(Tree tree) {
        if (null == tree) {
            return 0;
        }
        return 1 + Math.max(countPath(tree.l), countPath(tree.r));
    }

    public static boolean possibleSwap(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i;
                break;
            }
        }
        int count = 0;
        if (index != -1) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[index] > arr[i] && arr[i] != arr[i - 1]) {
                    count++;
                }
            }
        }
        return count <= 1;
    }

    public static class Tree {

        public int x;
        public Tree l;
        public Tree r;

        public Tree() {}

        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }
}
