package com.codeprac;

import java.util.Stack;

public class PalindromeLinkedList {


    public Result putInStackUntilMid(ListNode head) {
        ListNode slow = head, fast = head;

        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);

        var toggle = true;
        var length = 0;
        while (fast.next != null) {
            if (toggle) {
                slow = slow.next;
                stack.push(slow.val);
            }
            length++;
            fast = fast.next;
            toggle = !toggle;
        }
        return new Result(slow, stack, (length + 1) % 2 == 0);
    }

    public boolean isPalindrome(ListNode head) {
        var result = putInStackUntilMid(head);
        var mid = result.mid;
        var stack = result.stack;

        if (result.isEvenLength) stack.pop();
        while (mid != null) {
            if (!stack.empty() && mid.val != stack.pop()) return false;
            mid = mid.next;
        }
        return stack.empty();
    }

    static class Result {
        ListNode mid;
        Stack<Integer> stack;
        boolean isEvenLength;

        public Result(ListNode mid, Stack<Integer> stack, boolean isEvenLength) {
            this.mid = mid;
            this.stack = stack;
            this.isEvenLength = isEvenLength;
        }

    }
}
