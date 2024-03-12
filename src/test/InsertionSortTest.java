package test;

import algorithms.InsertionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    @Test
    void shouldSortSmallArray() {
        int[] array = {5, 2, 4, 6, 1, 3};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, array);
    }

    @Test
    void shouldSortLargeArray() {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        InsertionSort.sort(array);
        for (int i = 1; i <= array.length; i++) {
            Assertions.assertEquals(i, array[i - 1]);
        }
    }

    @Test
    void shouldSortArrayWithNegatives() {
        int[] array = {-3, -1, -4, -2, 0};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{-4, -3, -2, -1, 0}, array);
    }

    @Test
    void shouldSortArrayWithDuplicates() {
        int[] array = {5, 2, 2, 3, 3, 1};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 3, 5}, array);
    }

    @Test
    void shouldSortAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void shouldSortReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void shouldSortArrayWithAllIdenticalElements() {
        int[] array = {1, 1, 1, 1, 1};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 1, 1}, array);
    }

    @Test
    void shouldSortSingleElementArray() {
        int[] array = {1};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{1}, array);
    }

    @Test
    void shouldSortEmptyArray() {
        int[] array = {};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{}, array);
    }

    @Test
    void shouldSortArrayWithZerosAndNegatives() {
        int[] array = {0, -1, -3, 0, 2};
        InsertionSort.sort(array);
        Assertions.assertArrayEquals(new int[]{-3, -1, 0, 0, 2}, array);
    }
}