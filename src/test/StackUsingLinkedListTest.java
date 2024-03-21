package test;

import data_structures.StackUsingLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StackUsingLinkedListTest {

    @Nested
    @DisplayName("when new")
    class WhenNew {

        private StackUsingLinkedList stack;

        @BeforeEach
        void createNewStack() {
            stack = new StackUsingLinkedList();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws NoSuchElementException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(NoSuchElementException.class, stack::pop);
        }

        @Test
        @DisplayName("throws NoSuchElementException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(NoSuchElementException.class, stack::peek);
        }
    }

    @Nested
    @DisplayName("after pushing an element")
    class AfterPushing {

        private StackUsingLinkedList stack;

        @BeforeEach
        void pushAnElement() {
            stack = new StackUsingLinkedList();
            stack.push(1);
        }

        @Test
        @DisplayName("is not empty")
        void isNotEmpty() {
            assertFalse(stack.isEmpty());
        }

        @Test
        @DisplayName("returns the element when popped and becomes empty")
        void returnElementWhenPopped() {
            assertEquals(1, stack.pop());
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("returns the element when peeked but remains not empty")
        void returnElementWhenPeeked() {
            assertEquals(1, stack.peek());
            assertFalse(stack.isEmpty());
        }
    }

    @Nested
    @DisplayName("toString method")
    class ToStringMethod {

        @Test
        @DisplayName("correctly represents an empty stack")
        void correctlyRepresentsEmptyStack() {
            StackUsingLinkedList stack = new StackUsingLinkedList();
            assertEquals("[]", stack.toString());
        }

        @Test
        @DisplayName("correctly represents a non-empty stack")
        void correctlyRepresentsNonEmptyStack() {
            StackUsingLinkedList stack = new StackUsingLinkedList();
            stack.push(1);
            stack.push(2);
            assertEquals("[1, 2]", stack.toString());
        }
    }
}