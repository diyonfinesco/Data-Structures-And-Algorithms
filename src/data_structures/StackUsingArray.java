package data_structures;

import java.util.Arrays;

public class StackUsingArray {
    private int[] items;
    private int count = 0;

    public StackUsingArray(int length) {
        items = new int[length];
    }

    public void push(int item) {
        if (count == items.length) {
            throw new StackOverflowError();
        }

        items[count++] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] array = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(array);
    }
}
