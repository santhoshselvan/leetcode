package com.codeprac;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        var reverseResult = reverseKNodes(head, k);
        var returnResult = new ListNode(reverseResult.head.val, reverseResult.head.next);

        do {
            reverseResult = reverseKNodes(reverseResult.tail, k);
            returnResult = concatNodes(returnResult, reverseResult.head);
        } while (reverseResult.tail != null);
        return returnResult;
    }

    private ReverseResult reverseKNodes(ListNode head, int k) {
        ListNode probe = head;
        var counter = 0;

        while (probe != null && counter < k) {
            probe = probe.next;
            counter++;
        }

        if (counter != k) return new ReverseResult(head, null);

        assert head != null;
        return reverseNodes(head, k, probe);
    }

    public ReverseResult reverseNodes(ListNode head, int k, ListNode tail) {

        ListNode next, prev = null, curr = new ListNode(head.val, head.next);
        var counter = 0;
        while (counter < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }
        return new ReverseResult(prev, tail);
    }

    public ListNode concatNodes(ListNode one, ListNode two) {
        var oneItr = one;
        while(oneItr.next != null) {
            oneItr = oneItr.next;
        }
        oneItr.next = two;
        return one;
    }

    static class ReverseResult {
        ListNode head;
        ListNode tail;

        public ReverseResult(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

}
