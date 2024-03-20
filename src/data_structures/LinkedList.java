package data_structures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;

    private int size = 0;

    /*
        Runtime complexity - O(1)
    */
    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node firstNode = first;
            first = node;
            node.next = firstNode;
        }

        size++;
    }

    /*
        Runtime complexity - O(1)
    */
    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            Node lastNode = last;
            last = node;
            lastNode.next = node;
        }

        size++;
    }

    /*
        Runtime complexity - O(n)
    */
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    /*
        Runtime complexity - O(n)
    */
    public int indexOf(int item) {
        Node current = first;
        int index = 0;

        while (current != null) {
            if (current.value == item) {
                return index;
            }
            index++;
            current = current.next;
        }

        return -1;
    }

    /*
        Runtime complexity - O(1)
    */
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (isContainsOnlyOneElement()) {
            clear();
        } else {
            Node secondNode = first.next;
            first.next = null;
            first = secondNode;
        }

        size--;
    }

    /*
        Runtime complexity - O(n)
    */
    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (isContainsOnlyOneElement()) {
            clear();
        } else {
            Node current = first;
            Node previous = first;

            while (current != last) {
                previous = current;
                current = current.next;
            }

            previous.next = null;
            last = previous;
        }

        size--;
    }

    /*
        Runtime complexity - O(n)
    */
    public void print() {
        Node current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    /*
        Runtime complexity - O(n)
    */
    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;

        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    /*
        Runtime complexity - O(1)
    */
    public int size() {
        return size;
    }

    /*
        Runtime complexity - O(n)
    */
    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node previousNode = null;
        Node current = first;


        while (current != null) {
            Node next = current.next;
            current.next = previousNode;
            previousNode = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previousNode;
    }

    /*
        Runtime complexity - O(n)
    */
    public int getKthFromTheEnd(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (k < 1 || k > size) {
            throw new IllegalArgumentException();
        }

        Node targetPoint = first;
        int index = 0;

        Node current = first;

        while (current != null) {
            if (k <= index) {
                targetPoint = targetPoint.next;
            }
            index++;
            current = current.next;
        }

        return targetPoint.value;
    }

    private boolean isEmpty() {
        return first == null || last == null;
    }

    private void clear() {
        first = last = null;
    }

    private boolean isContainsOnlyOneElement() {
        return first == last;
    }
}
