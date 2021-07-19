package com.codeprac;

import org.junit.jupiter.api.Test;

import static com.codeprac.ListNode.of;
import static org.junit.jupiter.api.Assertions.*;

class ReverseNodesInKGroupTest {

    @Test
    void shouldReverseKNodesAtATime() {
        var reverseNodesInKGroup = new ReverseNodesInKGroup();
        assertEquals(of(3, of(2, of(1, of(4, of(5))))),
                reverseNodesInKGroup.reverseKGroup(
                        of(1, of(2, of(3, of(4, of(5))))),
                        3));

        assertEquals(of(2, of(1, of(4, of(3, of(5))))),
                reverseNodesInKGroup.reverseKGroup(
                        of(1, of(2, of(3, of(4, of(5))))),
                        2));

        assertEquals(of(1),
                reverseNodesInKGroup.reverseKGroup(
                        of(1),
                        1));
    }

    @Test
    void shouldReverseNodes() {
        ListNode until = of(999);
        assertEquals(of(1, of(2, of(3))), new ReverseNodesInKGroup().reverseNodes(
                of(3, of(2, of(1, until))),
                3,
                until
        ).head);
    }

    @Test
    void shouldConcatListNodes() {
        assertEquals(of(1, of(2, of(3, of(4)))), new ReverseNodesInKGroup().concatNodes(
                of(1, of(2)),
                of(3, of(4))
        ));


        assertEquals(of(1, of(2)), new ReverseNodesInKGroup().concatNodes(
                of(1, of(2)),
                null
        ));
    }
}
