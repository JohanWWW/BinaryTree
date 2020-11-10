package com.company;

import javax.management.openmbean.KeyAlreadyExistsException;

public class BinaryTree {

    private static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public void remove(int value) {
        /*
                10
              /   \
             2      16
           /   \
          1     4
               / \
              3   7
                 / \
                5   8
                     \
                      9
                     / \
                    null null
         */

        removeRecursive(root, value);
    }

    private void removeRecursive(Node currentTree, int valueToRemove) {

        if (valueToRemove < currentTree.value) {

            if (currentTree.left != null) {
                removeRecursive(currentTree.left, valueToRemove);
            }

        } else if (valueToRemove > currentTree.value) {

            if (currentTree.right != null) {
                removeRecursive(currentTree.right, valueToRemove);
            }

        } else {
            Node previous = null;
            Node temp = currentTree;
            while (temp.right != null) {
                previous = temp;
                temp = temp.right;
            }

            if (temp.left == null) {
                temp.value = currentTree.value;
                previous.right = null;
            } else {
                temp.left.value = currentTree.value;
                previous.left = null;
            }
        }
    }

    private Node insertRecursive(Node tree, int value) {
        if (tree == null) {
            tree = new Node(value);
            return tree;
        }

        if (value < tree.value) {
            tree.left = insertRecursive(tree.left, value);
        } else if (value > tree.value) {
            tree.right = insertRecursive(tree.right, value);
        } else {
            throw new KeyAlreadyExistsException(String.format("The value '%s' already exists", value));
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
        System.out.println(tree.value);
        printTreeInOrder(tree.right);
    }

    private void printTreeInReverseOrder(Node tree) {
        if (tree == null) {
            return;
        }
        printTreeInReverseOrder(tree.right);
        System.out.println(tree.value);
        printTreeInReverseOrder(tree.left);
    }
}
