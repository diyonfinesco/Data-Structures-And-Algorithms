package data_structures;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item){
        if(count == items.length){
            int[] newArray = new int[count * 2];

            for (int j = 0; j < items.length; j++) {
                newArray[j] = items[j];
            }

            items = newArray;
        }

        int i;

        for (i = count - 1; i >= 0; i--) {
            if(items[i] > item){
                items[i + 1] = items[i];
            }else{
                break;
            }
        }

        items[i + 1] = item;
        count++;
    }

    public int remove(){
        if(count == 0){
            throw new NoSuchElementException();
        }

        return items[--count];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, 0, count));
    }
}
