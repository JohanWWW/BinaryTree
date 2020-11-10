package com.company;

public class Main {

    public static void main(String[] args) {
        /*int[] test = {5, 3, 789, 1235, 2, 2, 3, 4, 23, 43};

        printArray(test);
        BubbleSort.Sort(test);
        System.out.println();
        printArray(test);*/


        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        //tree.insert(2);
        //tree.insert(10);
        tree.insert(16);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(7);
        tree.insert(5);
        tree.insert(8);
        tree.insert(9);

        tree.printTreeInOrder();
        tree.remove(10);
        tree.printTreeInOrder();
    }

    private static void printArray(int[] array) {
        for (int n : array) {
            System.out.println(n);
        }
    }
}
