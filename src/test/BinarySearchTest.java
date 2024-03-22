package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import algorithms.BinarySearch;

public class BinarySearchTest {

    @Test
    public void testTargetPresentIterative() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        assertEquals(2, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testTargetPresentRecursive() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 3;
        assertEquals(2, BinarySearch.searchByRecursion(array, target));
    }

    @Test
    public void testTargetNotPresentIterative() {
        int[] array = {1, 2, 4, 5};
        int target = 3;
        assertEquals(-1, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testTargetNotPresentRecursive() {
        int[] array = {1, 2, 4, 5};
        int target = 3;
        assertEquals(-1, BinarySearch.searchByRecursion(array, target));
    }

    @Test
    public void testEmptyArrayIterative() {
        int[] array = {};
        int target = 3;
        assertEquals(-1, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testEmptyArrayRecursive() {
        int[] array = {};
        int target = 3;
        assertEquals(-1, BinarySearch.searchByRecursion(array, target));
    }

    @Test(expected = NullPointerException.class)
    public void testNullArrayIterative() {
        int[] array = null;
        int target = 3;
        BinarySearch.searchByIteration(array, target);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArrayRecursive() {
        int[] array = null;
        int target = 3;
        BinarySearch.searchByRecursion(array, target);
    }

    @Test
    public void testSingleElementArrayIterative() {
        int[] array = {5};
        int target = 5;
        assertEquals(0, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testSingleElementArrayRecursive() {
        int[] array = {5};
        int target = 5;
        assertEquals(0, BinarySearch.searchByRecursion(array, target));
    }

    @Test
    public void testNegativeNumbersIterative() {
        int[] array = {-5, -4, -3, -2, -1};
        int target = -3;
        assertEquals(2, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testNegativeNumbersRecursive() {
        int[] array = {-5, -4, -3, -2, -1};
        int target = -3;
        assertEquals(2, BinarySearch.searchByRecursion(array, target));
    }

    @Test
    public void testEvenLengthArrayIterative() {
        int[] array = {1, 2, 3, 4};
        int target = 2;
        assertEquals(1, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testEvenLengthArrayRecursive() {
        int[] array = {1, 2, 3, 4};
        int target = 2;
        assertEquals(1, BinarySearch.searchByRecursion(array, target));
    }

    @Test
    public void testOddLengthArrayIterative() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 4;
        assertEquals(3, BinarySearch.searchByIteration(array, target));
    }

    @Test
    public void testOddLengthArrayRecursive() {
        int[] array = {1, 2, 3, 4, 5};
        int target = 4;
        assertEquals(3, BinarySearch.searchByRecursion(array, target));
    }
}