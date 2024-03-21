package data_structures;

import java.util.Arrays;

public class StackUsingArray {
    private int[] items;
    private int count = 0;

    public StackUsingArray(int length) {
        items = new int[length];
    }

    /*
        Runtime complexity - O(1)
    */
    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }

        items[count++] = item;
    }

    /*
        Runtime complexity - O(1)
    */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    /*
        Runtime complexity - O(1)
    */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    /*
        Runtime complexity - O(1)
    */
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] array = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(array);
    }
}
