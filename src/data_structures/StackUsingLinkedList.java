package data_structures;

import java.util.Arrays;

public class StackUsingLinkedList {
    private LinkedList list = new LinkedList();

    public void push(int item) {
        list.addLast(item);
    }

    public int pop() {
        int last = list.getKthFromTheEnd(1);
        list.deleteLast();
        return last;
    }

    public int peek() {
        return list.getKthFromTheEnd(1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(list.toArray());
    }
}
