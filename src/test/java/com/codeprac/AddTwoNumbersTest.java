package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    @Test
    void shouldAddTwoNumbers() {
        var addTwoNumbers = new AddTwoNumbers();

        assertEquals(new ListNode(7, new ListNode(0, new ListNode(8))),
                addTwoNumbers.addTwoNumbers(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4)))
                ));

        assertEquals(new ListNode(7, new ListNode(0, new ListNode(8, new ListNode(7)))),
                addTwoNumbers.addTwoNumbers(
                        new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(7)))),
                        new ListNode(5, new ListNode(6, new ListNode(4)))
                ));

        assertEquals(new ListNode(7, new ListNode(0, new ListNode(8, new ListNode(7)))),
                addTwoNumbers.addTwoNumbers(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7))))
                ));

        assertEquals(new ListNode(7, new ListNode(0, new ListNode(0, new ListNode(1)))),
                addTwoNumbers.addTwoNumbers(
                        new ListNode(2, new ListNode(4, new ListNode(3))),
                        new ListNode(5, new ListNode(6, new ListNode(6)))
                ));
    }
}
