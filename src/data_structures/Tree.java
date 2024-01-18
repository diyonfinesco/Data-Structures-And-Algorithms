package data_structures;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
    }

    private Node root;

    // O(log n)
    public void insert(int value) {
        Node node = new Node();
        node.value = value;

        if (root == null) {
            root = node;
        } else {
            Node current = root;

            while (true) {

                if (value < current.value) {

                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }

                    current = current.leftChild;
                } else {

                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }

                    current = current.rightChild;
                }
            }
        }
    }

    // O(log n)
    public boolean find(int value) {
        Node current = root;

        while (current != null) {

            if (current.value == value) {
                return true;
            }

            if (current.value < value) {
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }

        return false;
    }
}
