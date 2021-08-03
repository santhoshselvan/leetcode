package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    @Test
    void shouldFindAmountOfRainWaterTrapped() {
        var trappingRainWater = new TrappingRainWater();

        assertEquals(1, trappingRainWater.trap(new int[]{1, 0, 2}));
        assertEquals(3, trappingRainWater.trap(new int[]{2, 0, 1, 3}));
        assertEquals(3, trappingRainWater.trap(new int[]{2, 0, 1, 2}));
        assertEquals(1, trappingRainWater.trap(new int[]{2, 0, 1}));
        assertEquals(9, trappingRainWater.trap(new int[]{4, 2, 0, 3, 2, 5}));
        assertEquals(6, trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
