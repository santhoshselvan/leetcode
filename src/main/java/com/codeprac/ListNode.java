package com.codeprac;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of (int val, ListNode next) {
        return new ListNode(val, next);
    }

    public static ListNode of (int val) {
        return new ListNode(val);
    }
}
