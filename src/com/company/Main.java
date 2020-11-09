package com.company;

public class Main {

    public static void main(String[] args) {
        int[] test = {5, 3, 789, 1235, 2, 2, 3, 4, 23, 43};

        printArray(test);
        BubbleSort.Sort(test);
        System.out.println();
        printArray(test);

    }

    private static void printArray(int[] array) {
        for (int n : array) {
            System.out.println(n);
        }
    }
}
