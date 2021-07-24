package com.codeprac;

import org.junit.jupiter.api.Test;

import static com.codeprac.ListNode.of;
import static org.junit.jupiter.api.Assertions.*;

class MiddleOfLinkedListTest {

    @Test
    void shouldFindMiddleOfLinkedList() {
        var middleOfLinkedList = new MiddleOfLinkedList();

        assertEquals(of(3, of(4, of(5))),
                middleOfLinkedList.middleNode(of(1, of(2, of(3, of(4, of(5))))))
        );

        assertEquals(of(4, of(5, of(6))),
                middleOfLinkedList.middleNode(of(1, of(2, of(3, of(4, of(5, of(6)))))))
        );

        assertEquals(of(1),
                middleOfLinkedList.middleNode(of(1))
        );
    }
}
