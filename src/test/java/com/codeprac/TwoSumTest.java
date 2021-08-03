package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void shouldFindTwoNumbersSummingToValue() {
        var twoSum = new TwoSum();

        assertArrayEquals(new int[] {0, 1}, twoSum.twoSum(new int[] {2,7,11,15}, 9));
        assertArrayEquals(new int[] {2, 3}, twoSum.twoSum(new int[] {2,7,11,5}, 16));
    }
}
