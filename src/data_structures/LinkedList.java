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

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        }else {
            Node firstNode = first;
            first = node;
            node.next = firstNode;
        }

        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = node;
            last = node;
        }else {
            Node lastNode = last;
            last = node;
            lastNode.next = node;
        }

        size++;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

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

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (isContainsOnlyOneElement()) {
            clear();
        }else{
            Node secondNode = first.next;
            first.next = null;
            first = secondNode;
        }

        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (isContainsOnlyOneElement()) {
            clear();
        }else {
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

    public void print() {
        Node current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int[] toArray(){
        int[] array = new int[size];
        int index = 0;

        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public int size() {
        return size;
    }

    public void reverse(){
        if(isEmpty()){
            return;
        }

        Node previousNode = null;
        Node current = first;


        while (current != null){
            Node next = current.next;
            current.next = previousNode;
            previousNode = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previousNode;
    }

    public int getKthFromTheEnd(int k){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if(k < 1 || k > size){
            throw new IllegalArgumentException();
        }

        Node targetPoint = first;
        int index = 0;

        Node current = first;

        while (current != null){
            if(k <= index){
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
