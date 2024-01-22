package algorithms;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;

            for (int j = 1; j < array.length - i; j++) {

                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    swap(array, j - 1, j);
                }
            }

            if (isSorted) {
                return;
            }
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
