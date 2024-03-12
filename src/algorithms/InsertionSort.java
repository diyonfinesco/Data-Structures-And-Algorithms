package algorithms;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j > -1 && array[j] > current) {
                System.out.println("Hello");
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }
}