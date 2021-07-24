package com.codeprac;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        var toggle = true;
        while(fast.next != null) {
            if (toggle) {
                slow = slow.next;
            }
            fast = fast.next;
            toggle = !toggle;
        }
        return slow;
    }
}
