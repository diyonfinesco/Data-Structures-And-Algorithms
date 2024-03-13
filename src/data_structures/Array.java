package data_structures;

public class Array {

    private int[] items;
    private int count;

    public Array(int size){
        items = new int[size];
    }

    /*
        Runtime complexity - O(n)
    */
    public void insert(int item){

        if(count == items.length){
            int[] temp = new int[count * 2];

            for (int i = 0; i < count; i++) {
                temp[i] = items[i];
            }

            items = temp;
        }

        items[count++] = item;
    }

    /*
        Runtime complexity - O(n)
    */
    public void removeAt(int index){
        validateIndex(index);

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    /*
        Runtime complexity - O(n)
    */
    public int getIndexByValue(int item){
        for (int i = 0; i < count; i++) {
            if(items[i] == item){
                return i;
            }
        }

        return -1;
    }

    /*
        Runtime complexity - O(1)
    */
    public int getValueByIndex(int index){
        validateIndex(index);
        return items[index];
    }

    // check if the index within range
    private void validateIndex(int index){
        if(index < 0 || index >= count){
            throw new IllegalArgumentException("invalid index");
        }
    }
}
