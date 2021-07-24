package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.codeprac.ListNode.of;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    void findMidOfLinkedList() {
        var palindromeLinkedList = new PalindromeLinkedList();

        var result = palindromeLinkedList.putInStackUntilMid(of(1, of(2, of(3))));
        var expectedStack = putInStack(1, 2);
        assertEquals(of(2, of(3)), result.mid);
        assertEquals(expectedStack, result.stack);

        result = palindromeLinkedList.putInStackUntilMid(of(1, of(2, of(3, of(4)))));
        expectedStack = putInStack(1, 2, 3);
        assertEquals(of(3, of(4)), result.mid);
        assertEquals(expectedStack, result.stack);

        result = palindromeLinkedList.putInStackUntilMid(of(1, of(2)));
        expectedStack = putInStack(1, 2);
        assertEquals(of(2), result.mid);
        assertEquals(expectedStack, result.stack);

        result = palindromeLinkedList.putInStackUntilMid(of(1));
        expectedStack = putInStack(1);
        assertEquals(of(1), result.mid);
        assertEquals(expectedStack, result.stack);
    }

    private Stack<Integer> putInStack(int... items) {
        var expectedStack = new Stack<Integer>();
        for (int item : items) {
            expectedStack.push(item);
        }
        return expectedStack;
    }

    @Test
    void shouldCheckPalindromeLinkedList() {
        var palindromeLinkedList = new PalindromeLinkedList();

        assertTrue(palindromeLinkedList.isPalindrome(of(1, of(2, of(1)))));
        assertTrue(palindromeLinkedList.isPalindrome(of(1, of(2, of(2, of(1))))));
        assertTrue(palindromeLinkedList.isPalindrome(of(1)));
        assertFalse(palindromeLinkedList.isPalindrome(of(1, of(2, of(1, of(2))))));
        assertFalse(palindromeLinkedList.isPalindrome(of(1, of(2))));
    }
}
