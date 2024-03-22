package data_structures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int length) {
        items = new int[length];
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int frontItem = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return frontItem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
