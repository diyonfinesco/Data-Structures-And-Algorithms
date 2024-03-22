package test;

import algorithms.LinearSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinearSearchTest {

    @Test
    public void testItemPresent() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        int expectedIndex = 2;
        assertEquals(expectedIndex, LinearSearch.search(array, target));
    }

    @Test
    public void testItemNotPresent() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 6;
        assertEquals(-1, LinearSearch.search(array, target));
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        int target = 3;
        assertEquals(-1, LinearSearch.search(array, target));
    }

    @Test
    public void testNullArray() {
        int[] array = null;
        int target = 3;
        assertThrows(NullPointerException.class, () -> LinearSearch.search(array, target));
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] array = {1, 3, 3, 4, 5};
        int target = 3;
        int expectedIndex = 1;
        assertEquals(expectedIndex, LinearSearch.search(array, target));
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] array = {-3, -2, -1, 0, 1};
        int target = -1;
        int expectedIndex = 2;
        assertEquals(expectedIndex, LinearSearch.search(array, target));
    }
}