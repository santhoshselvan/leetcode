package com.codeprac;


import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.Optional.empty;

public class MergeManySortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        var valueHolder = new ValueHolder(lists.length);
        valueHolder.fillAll(lists);

        ListNode resultHead = null;
        ListNode resultItr = null;

        var smallest = valueHolder.getSmallest();
        while(smallest != null) {
            if (resultItr == null) {
                resultItr = new ListNode(smallest.value);
                resultHead = resultItr;
            } else {
                resultItr.next = new ListNode(smallest.value);
                resultItr = resultItr.next;
            }

            var newEntry = valueHolder.fillIndex(smallest.index, lists);

            if (newEntry.isPresent() && newEntry.get().value < smallest.value) {
                smallest = newEntry.get();
            } else {
                smallest = valueHolder.getSmallest();
            }
        }
        return resultHead;
    }

    static class ValueHolder {

        PriorityQueue<Entry> priorityQueue;

        public ValueHolder(int size) {
            priorityQueue = new PriorityQueue<>(size, Comparator.comparing(Entry::getValue));
        }

        void fillAll(ListNode[] lists) {
            IntStream.range(0, lists.length).forEach(i -> {
                if (lists[i] != null) priorityQueue.add(new Entry(lists[i].val, i));
            });
        }

        public Optional<Entry> fillIndex(int index, ListNode[] lists) {
            if (lists[index] == null || lists[index].next == null) return empty();

            lists[index] = lists[index].next;

            var addedEntry = new Entry(lists[index].val, index);
            priorityQueue.add(addedEntry);

            return Optional.of(addedEntry);
        }

        Entry getSmallest() {
            return priorityQueue.poll();
        }

        static class Entry {
            Integer value;
            int index;

            public Integer getValue() {
                return value;
            }

            public Entry(Integer value, int index) {
                this.value = value;
                this.index = index;
            }
        }

    }
}
