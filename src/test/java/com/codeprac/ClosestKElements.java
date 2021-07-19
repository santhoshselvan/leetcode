package com.codeprac;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class ClosestKElements {
    public List<Integer> findClosestElements(int[] arr, int numberOfItemsToReturn, int x) {
        PriorityQueue<Slot> pq = new PriorityQueue<>(numberOfItemsToReturn, comparingInt(Slot::getDifference).reversed());

        stream(arr).forEach(element -> {
            int difference = difference(element, x);
            if (isPqFull(pq, numberOfItemsToReturn)) {
                Slot peeked = pq.peek();
                assert peeked != null;
                if (peeked.difference > difference) {
                    pq.poll();
                    pq.add(new Slot(element, difference));
                }
            } else {
                pq.add(new Slot(element, difference));
            }
        });

        return pq.stream().mapToInt(Slot::getValue).sorted().boxed().collect(toList());
    }

    private int difference(int i, int j) {
        return Math.abs(i - j);
    }

    private static boolean isPqFull(PriorityQueue<Slot> pq, int capacity) {
        return capacity <= pq.size();
    }

    static class Slot {
        int value;
        int difference;

        public Slot(int value, int difference) {
            this.value = value;
            this.difference = difference;
        }

        public int getDifference() {
            return difference;
        }

        public Integer getValue() {
            return value;
        }
    }

}
