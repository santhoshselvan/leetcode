package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryOnQueuesTest {

    @Test
    void shouldFindNumberOfSegments() {
        var queryOnQueues = new QueryOnQueues();

        assertArrayEquals(new int[] {4, 3}, queryOnQueues.solve(4, new int[]{4, 2, 1, 3}, 2, new int[] {1, 4}));
        assertArrayEquals(new int[] {3, 2}, queryOnQueues.solve(3, new int[]{1, 2, 3}, 2, new int[] {3, 2}));
        assertArrayEquals(new int[] {3, 2}, queryOnQueues.solve(5, new int[]{4, 2, 3, 5, 1}, 2, new int[] {1, 3}));
    }

    @Test
    void shouldNumberOfItemsSmallerThanOnLeft() {
        var queryOnQueues = new QueryOnQueues();
        assertEquals(0, queryOnQueues.findNumberOfItemsSmallerThanOnLeft(1, new int[] {4, 2, 3, 5, 1}));
        assertEquals(1, queryOnQueues.findNumberOfItemsSmallerThanOnLeft(3, new int[] {4, 2, 3, 5, 1}));
        assertEquals(0, queryOnQueues.findNumberOfItemsSmallerThanOnLeft(5, new int[] {4, 2, 3, 5, 1}));
        assertEquals(3, queryOnQueues.findNumberOfItemsSmallerThanOnLeft(4, new int[] {4, 2, 3, 5, 1}));
        assertEquals(1, queryOnQueues.findNumberOfItemsSmallerThanOnLeft(4, new int[] {4, 8, 3, 5, 1}));
    }

    @Test
    void shouldNumberOfItemsSmallerThanOnRight() {
        var queryOnQueues = new QueryOnQueues();
        assertEquals(2, queryOnQueues.findNumberOfItemsSmallerThanOnRight(1, new int[] {4, 2, 3, 5, 1}));
        assertEquals(0, queryOnQueues.findNumberOfItemsSmallerThanOnRight(3, new int[] {4, 2, 3, 5, 1}));
        assertEquals(0, queryOnQueues.findNumberOfItemsSmallerThanOnRight(5, new int[] {4, 2, 3, 5, 1}));
        assertEquals(1, queryOnQueues.findNumberOfItemsSmallerThanOnRight(4, new int[] {4, 2, 3, 5, 1}));
    }
}
