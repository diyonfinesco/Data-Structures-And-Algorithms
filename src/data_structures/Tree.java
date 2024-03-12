package data_structures;

public class Tree {
    private Node root;

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

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        if (isLeaf(root)) {
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // For binary search tree
    public int min() {
        if (root == null) {
            return -1;
        }

        Node current = root;
        Node last = current;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    // For binary tree
    public int findMin() {
        return findMin(root);
    }

    private int findMin(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }

        int left = findMin(root.leftChild);
        int right = findMin(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equalsTree(Tree tree) {
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public void swapRoot() {
        if (root == null) {
            return;
        }

        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isValidBinaryTree() {
        return isValidBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBinaryTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (min < root.value && root.value < max) {
            return isValidBinaryTree(root.leftChild, min, root.value) && isValidBinaryTree(root.rightChild, root.value, max);
        }

        return false;
    }

    public void printNodesAtDistance(int k) {
        printNodesAtDistance(k, root);
    }

    private void printNodesAtDistance(int k, Node root) {

        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(k - 1, root.leftChild);
        printNodesAtDistance(k - 1, root.rightChild);
    }

    public void traverseBreadthFirst() {
        for (int i = 0; i <= height(); i++) {
            printNodesAtDistance(i);
        }
    }

    private boolean isLeaf(Node node) {
        return node.rightChild == null && node.leftChild == null;
    }

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
    }
}
