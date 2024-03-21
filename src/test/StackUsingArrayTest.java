package test;

import data_structures.StackUsingArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackUsingArrayTest {

    @Nested
    @DisplayName("when new")
    class WhenNew {

        private StackUsingArray stack;

        @BeforeEach
        void createNewStack() {
            stack = new StackUsingArray(3);
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws IllegalStateException when popped")
        void throwsExceptionWhenPopped() {
            assertThrows(IllegalStateException.class, stack::pop);
        }

        @Test
        @DisplayName("throws IllegalStateException when peeked")
        void throwsExceptionWhenPeeked() {
            assertThrows(IllegalStateException.class, stack::peek);
        }
    }

    @Nested
    @DisplayName("after pushing an element")
    class AfterPushing {

        private StackUsingArray stack;

        @BeforeEach
        void pushAnElement() {
            stack = new StackUsingArray(3);
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
    @DisplayName("when full")
    class WhenFull {

        private StackUsingArray stack;

        @BeforeEach
        void fillStack() {
            stack = new StackUsingArray(2);
            stack.push(1);
            stack.push(2);
        }

        @Test
        @DisplayName("throws StackOverflowError when pushing another element")
        void throwsErrorWhenPushingIntoFullStack() {
            assertThrows(StackOverflowError.class, () -> stack.push(3));
        }
    }

    @Nested
    @DisplayName("toString method")
    class ToStringMethod {

        @Test
        @DisplayName("correctly represents an empty stack")
        void correctlyRepresentsEmptyStack() {
            StackUsingArray stack = new StackUsingArray(3);
            assertEquals("[]", stack.toString());
        }

        @Test
        @DisplayName("correctly represents a non-empty stack")
        void correctlyRepresentsNonEmptyStack() {
            StackUsingArray stack = new StackUsingArray(3);
            stack.push(1);
            stack.push(2);
            assertEquals("[1, 2]", stack.toString());
        }
    }
}