package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(16);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(7);
        tree.insert(5);
        tree.insert(8);
        tree.insert(9);
        tree.insert(32);
        tree.insert(-64);
        tree.insert(-42);
        tree.insert(-128);

        tree.printTreeInOrder();

        tree.remove(10);
        tree.remove(16);
        tree.remove(32);
        tree.remove(1);

        System.out.println();

        tree.printTreeInOrder();
    }
}
