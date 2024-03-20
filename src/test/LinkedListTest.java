package test;

import data_structures.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList();
    }

    @Nested
    @DisplayName("Tests for addFirst method")
    class AddFirstTests {

        @Test
        public void addFirstToEmptyList() {
            list.addFirst(10);
            assertEquals(1, list.size());
            assertTrue(list.contains(10));
        }

        @Test
        public void addFirstToNonEmptyList() {
            list.addFirst(10);
            list.addFirst(20);
            assertEquals(2, list.size());
            assertEquals(20, list.toArray()[0]);
        }
    }

    @Nested
    @DisplayName("Tests for addLast method")
    class AddLastTests {

        @Test
        public void addLastToEmptyList() {
            list.addLast(10);
            assertEquals(1, list.size());
            assertTrue(list.contains(10));
        }

        @Test
        public void addLastToNonEmptyList() {
            list.addLast(10);
            list.addLast(20);
            assertEquals(2, list.size());
            assertEquals(20, list.toArray()[1]);
        }
    }

    @Nested
    @DisplayName("Tests for contains method")
    class ContainsTests {

        @Test
        public void containsOnEmptyList() {
            assertFalse(list.contains(10));
        }

        @Test
        public void containsWithExistingElement() {
            list.addFirst(10);
            assertTrue(list.contains(10));
        }

        @Test
        public void containsWithNonExistingElement() {
            list.addFirst(10);
            assertFalse(list.contains(20));
        }
    }

    @Nested
    @DisplayName("Tests for indexOf method")
    class IndexOfTests {
        @Test
        public void indexOfElementInEmptyList() {
            assertEquals(-1, list.indexOf(10));
        }

        @Test
        public void indexOfNonExistingElement() {
            list.addFirst(20);
            assertEquals(-1, list.indexOf(10));
        }

        @Test
        public void indexOfExistingElement() {
            list.addFirst(10);
            list.addLast(20);
            assertEquals(0, list.indexOf(10));
            assertEquals(1, list.indexOf(20));
        }
    }

    @Nested
    @DisplayName("Tests for deleteFirst method")
    class DeleteFirstTests {

        @Test
        public void deleteFirstOnEmptyList() {
            assertThrows(NoSuchElementException.class, () -> list.deleteFirst());
        }

        @Test
        public void deleteFirstWithOneElement() {
            list.addFirst(10);
            list.deleteFirst();
            assertEquals(0, list.size());
        }

        @Test
        public void deleteFirstWithMultipleElements() {
            list.addFirst(10);
            list.addFirst(20);
            list.deleteFirst();
            assertEquals(1, list.size());
            assertFalse(list.contains(20));
        }
    }

    @Nested
    @DisplayName("Tests for deleteLast method")
    class DeleteLastTests {
        @Test
        public void deleteLastOnEmptyList() {
            assertThrows(NoSuchElementException.class, () -> list.deleteLast());
        }

        @Test
        public void deleteLastWithOneElement() {
            list.addFirst(10);
            list.deleteLast();
            assertEquals(0, list.size());
        }

        @Test
        public void deleteLastWithMultipleElements() {
            list.addFirst(10);
            list.addLast(20);
            list.deleteLast();
            assertEquals(1, list.size());
            assertFalse(list.contains(20));
            assertTrue(list.contains(10));
        }
    }

    @Nested
    @DisplayName("Tests for toArray method")
    class ToArrayTests {
        @Test
        public void toArrayEmptyList() {
            assertArrayEquals(new int[]{}, list.toArray());
        }

        @Test
        public void toArrayNonEmptyList() {
            list.addFirst(10);
            list.addLast(20);
            assertArrayEquals(new int[]{10, 20}, list.toArray());
        }
    }

    @Nested
    @DisplayName("Tests for size method")
    class SizeTests {
        @Test
        public void sizeOfEmptyList() {
            assertEquals(0, list.size());
        }

        @Test
        public void sizeAfterAddingElements() {
            list.addFirst(10);
            list.addLast(20);
            assertEquals(2, list.size());
        }

        @Test
        public void sizeAfterRemovingElements() {
            list.addFirst(10);
            list.addLast(20);
            list.deleteFirst();
            assertEquals(1, list.size());
        }
    }

    @Nested
    @DisplayName("Tests for reverse method")
    class Reverse {
        @Test
        public void reverseList() {
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);

            list.reverse();

            assertArrayEquals(new int[]{30, 20, 10}, list.toArray());
        }
    }

    @Nested
    @DisplayName("Tests for getKthFromTheEnd method")
    class GetKthFromTheEnd {
        @Test
        public void getFirstElementFromTheEnd() {
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);

            assertEquals(30, list.getKthFromTheEnd(1));
        }
        @Test
        public void getSecondElementFromTheEnd() {
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);


            assertEquals(20, list.getKthFromTheEnd(2));
        }

        @Test
        public void getThirdElementFromTheEnd() {
            list.addLast(10);
            list.addLast(20);
            list.addLast(30);

            assertEquals(10, list.getKthFromTheEnd(3));
        }

        @Test
        public void getFirstElementFromTheEndWithEmptyList() {
            assertThrows(NoSuchElementException.class, () -> list.getKthFromTheEnd(1));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionForNegativeNumber() {
            list.addLast(10);

            assertThrows(IllegalArgumentException.class, () -> list.getKthFromTheEnd(-1));
        }

        @Test
        public void shouldThrowIllegalArgumentExceptionForInvalidArgument() {
            list.addLast(10);

            assertThrows(IllegalArgumentException.class, () -> list.getKthFromTheEnd(2));
        }
    }
}