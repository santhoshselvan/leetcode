package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    @Test
    void shouldFindMedianOfTwoSortedArrays() {
        assertEquals(2, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
        assertEquals(0, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));
        assertEquals(2, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {2}, new int[] {}));
        assertEquals(1, new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[] {}, new int[] {1}));


        assertEquals(2, new MedianOfTwoSortedArrays().findMedianSortedArrays_alternate(new int[] {1, 3}, new int[] {2}));
        assertEquals(2.5, new MedianOfTwoSortedArrays().findMedianSortedArrays_alternate(new int[] {1, 2}, new int[] {3, 4}));
        assertEquals(0, new MedianOfTwoSortedArrays().findMedianSortedArrays_alternate(new int[] {0, 0}, new int[] {0, 0}));
        assertEquals(2, new MedianOfTwoSortedArrays().findMedianSortedArrays_alternate(new int[] {2}, new int[] {}));
        assertEquals(1, new MedianOfTwoSortedArrays().findMedianSortedArrays_alternate(new int[] {}, new int[] {1}));
    }

    @Test
    void mergeTwoSortedListToOneSortedList() {
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 4}, new MedianOfTwoSortedArrays().merge(new int[] {1, 2}, new int[] {2, 4})));
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 4, 4}, new MedianOfTwoSortedArrays().merge(new int[] {1, 2, 3, 4}, new int[] {2, 4})));
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 4, 4}, new MedianOfTwoSortedArrays().merge(new int[] {2, 4}, new int[] {1, 2, 3, 4})));
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 4, 4}, new MedianOfTwoSortedArrays().merge(new int[] {1, 2, 3, 4}, new int[] {2, 4})));
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 3, 4, 4}, new MedianOfTwoSortedArrays().merge(new int[] {1, 2, 3, 4}, new int[] {2, 4})));
    }
}
