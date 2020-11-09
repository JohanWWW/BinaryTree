package com.company;

public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*
                    8
                   / \
                  3   10
                 / \   \
                1   6   13
         */


        /*
                        2
                       /|\
                      1 2 6
                         / \
                        3   500
                           /   \
                         439   1700
                         /     /  \
                        32   550  1701
                        |
                        32
                        |
                        32
         */

        /*tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(2);
        tree.insert(500);
        tree.insert(439);
        tree.insert(32);
        tree.insert(500);
        tree.insert(32);
        tree.insert(500);
        tree.insert(32);*/

        /*tree.insert(5);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);*/

        tree.insert(10);
        tree.insert(2);
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

        tree.printTreeInOrder();

        tree.remove(2);
        tree.remove(2);


        tree.printTreeInOrder();
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    public void remove(int key) {
        /*
                10
              / | \
             2  10  16
           / | \
          1  2  4
               / \
              3   7
                 / \
                5   8
                     \
                      9
         */

        removeRecursive(root, null, key);
    }

    private void removeRecursive(Node tree, Node parentTree, int keyToRemove) {

        if (keyToRemove < tree.key) {

            if (tree.left != null)
                removeRecursive(tree.left, tree, keyToRemove);
            else
                parentTree.left = tree;

        } else if (keyToRemove > tree.key) {

            if (tree.right != null)
                removeRecursive(tree.right, tree, keyToRemove);

        } else {

            if (tree.middle != null)
                removeRecursive(tree.middle, tree, keyToRemove);
            else
                parentTree.middle = null;
        }

        /*while (current.right != nodeToRemove) {
            current = current.right;
        }*/
    }

    private Node insertRecursive(Node tree, int key) {
        if (tree == null) {
            tree = new Node(key);
            return tree;
        }

        if (key < tree.key) {
            tree.left = insertRecursive(tree.left, key);
        } else if (key > tree.key) {
            tree.right = insertRecursive(tree.right, key);
        } else {
            tree.middle = insertRecursive(tree.middle, key);
        }

        return tree;
    }

    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    public void printTreeInReverseOrder() {
        printTreeInReverseOrder(root);
    }

    private void printTreeInOrder(Node tree) {
        if (tree == null) {
            return;
        }
        printTreeInOrder(tree.left);
        System.out.println(tree.key);
        printMiddleBranch(tree.middle);
        printTreeInOrder(tree.right);
    }

    private void printTreeInReverseOrder(Node tree) {
        if (tree == null) {
            return;
        }
        printTreeInReverseOrder(tree.right);
        System.out.println(tree.key);
        printMiddleBranch(tree.middle);
        printTreeInReverseOrder(tree.left);
    }

    private void printMiddleBranch(Node tree) {
        Node current = tree;
        while (current != null) {
            System.out.println(current.key);
            current = current.middle;
        }
    }

    private static class Node {
        Node left;
        Node middle;
        Node right;
        int key;

        Node(int key) {
            this.key = key;
        }
    }
}
