package test;

import data_structures.Array;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    private Array array;

    @BeforeEach
    void setUp() {
        array = new Array(5); // Create an array with initial size 5
    }

    @Test
    void itShouldInsertItems() {
        array.insert(10);
        array.insert(20);
        array.insert(30);

        assertEquals(10, array.getValueByIndex(0));
        assertEquals(20, array.getValueByIndex(1));
        assertEquals(30, array.getValueByIndex(2));
    }

    @Test
    void itShouldInsertMoreItemsThanGivenSize() {
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.insert(50);
        array.insert(60);

        assertEquals(10, array.getValueByIndex(0));
        assertEquals(20, array.getValueByIndex(1));
        assertEquals(30, array.getValueByIndex(2));
        assertEquals(40, array.getValueByIndex(3));
        assertEquals(50, array.getValueByIndex(4));
        assertEquals(60, array.getValueByIndex(5));
    }

    @Nested
    class removeAt {
        @Test
        void itShouldRemoveAnItem() {
            array.insert(10);
            array.insert(20);
            array.insert(30);

            array.removeAt(1);

            assertEquals(10, array.getValueByIndex(0));
            assertEquals(30, array.getValueByIndex(1));
        }

        @Test
        void itShouldThrowAnErrorForInvalidIndex() {
            assertThrows(IllegalArgumentException.class, () -> array.removeAt(0));
        }

    }

    @Nested
    class itShouldReturnAnIndexForGivenValue {
        @Test
        void testGetIndexByValue() {
            array.insert(10);
            array.insert(20);
            array.insert(30);

            assertEquals(1, array.getIndexByValue(20));
            assertEquals(-1, array.getIndexByValue(40));
        }

        @Test
        void itShouldReturnMinusOneForNonExistItem() {
            array.insert(10);
            array.insert(20);
            array.insert(30);

            assertEquals(-1, array.getIndexByValue(40));
        }
    }

    @Nested
    class getValueByIndex {
        @Test
        void itShouldReturnValueForGivenIndex() {
            array.insert(10);
            array.insert(20);
            array.insert(30);

            assertEquals(20, array.getValueByIndex(1)); // Value at index 1 is 20
        }

        @Test
        void itShouldThrowAnErrorForInvalidIndex() {
            array.insert(10);

            assertThrows(IllegalArgumentException.class, () -> array.getValueByIndex(1));
        }
    }
}