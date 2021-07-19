package com.codeprac;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode itr1 = l1, itr2 = l2, result = null, resultItr = result;
        int carry = 0;
        while(itr1 != null || itr2 != null) {
            var sum = getValue(itr1) + getValue(itr2) + carry;
            var resultNodeValue = sum % 10;
            var resultNode = new ListNode(resultNodeValue);
            if (result == null) {
                result = resultNode;
                resultItr = result;
            } else {
                resultItr.next = resultNode;
                resultItr = getNext(resultItr);
            }
            itr1 = getNext(itr1);
            itr2 = getNext(itr2);
            carry = getCarry(sum);
        }

        if (carry == 1) {
            resultItr.next = new ListNode(carry);
        }
        return result;
    }

    private int getCarry(int sum) {
        return sum / 10;
    }

    private ListNode getNext(ListNode itr) {
        return itr == null ? null : itr.next;
    }

    private int getValue(ListNode itr) {
        return itr == null ? 0 : itr.val;
    }
}
