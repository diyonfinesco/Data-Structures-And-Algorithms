package test;

import algorithms.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void shouldSortLargeArray() {
        final int[] array = {2, 6, 2, 7, 1, 84, -3, 41, 75, 122, 31, -1};
        final int[] sortedArray = {-3, -1, 1, 2, 2, 6, 7, 31, 41, 75, 84, 122};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortFiveElements() {
        final int[] array = {-3, 41, 75, 122, -1, 84};
        final int[] sortedArray = {-3, -1, 41, 75, 84, 122};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortTwoElements() {
        final int[] array = {2, 6};
        final int[] sortedArray = {2, 6};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortEmptyArray() {
        final int[] array = {};
        final int[] sortedArray = {};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortAlreadySortedArray() {
        final int[] array = {1, 2, 3, 4, 5};
        final int[] sortedArray = {1, 2, 3, 4, 5};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortReverseSortedArray() {
        final int[] array = {5, 4, 3, 2, 1};
        final int[] sortedArray = {1, 2, 3, 4, 5};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortArrayWithDuplicates() {
        final int[] array = {3, 1, 2, 1, 3};
        final int[] sortedArray = {1, 1, 2, 3, 3};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortArrayWithAllIdenticalElements() {
        final int[] array = {1, 1, 1, 1, 1};
        final int[] sortedArray = {1, 1, 1, 1, 1};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }

    @Test
    void shouldSortArrayWithNegativesAndZeros() {
        final int[] array = {-1, 0, -3, 0, 2};
        final int[] sortedArray = {-3, -1, 0, 0, 2};

        BubbleSort.sort(array);

        Assertions.assertArrayEquals(sortedArray, array);
    }
}