package com.codeprac;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MergeManySortedListsTest {

    @Test
    void shouldMergeKSortedLists() {
        ListNode result = new MergeManySortedLists().mergeKLists(new ListNode[]{
                buildListNode(1, 4, 5),
                buildListNode(1, 3, 4),
                buildListNode(2, 6)});

        assertEquals(buildListNode(1, 1, 2, 3, 4, 4, 5, 6), result);
        assertEquals(null, new MergeManySortedLists().mergeKLists(new ListNode[]{}));
        assertEquals(null, new MergeManySortedLists().mergeKLists(new ListNode[]{null}));

    }

    @Test
    void buildsListNode() {
        var listNode = buildListNode(1, 4, 5);
        assertEquals(1, listNode.val);

        listNode = listNode.next;
        assertEquals(4, listNode.val);

        listNode = listNode.next;
        assertEquals(5, listNode.val);
    }

    @NotNull
    private ListNode buildListNode(int... values) {
        List<ListNode> result = Arrays.stream(values).mapToObj(ListNode::new).collect(Collectors.toList());

        var itr = result.get(0);
        for (int i = 1; i < result.size(); i++) {
            var next = result.get(i);
            itr.next = next;
            itr = next;

        }
        return result.get(0);
    }
}
