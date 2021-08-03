package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void shouldGenerateAllPermutations() {
        var permutations = new Permutations();

        assertEquals(List.of(List.of(1, 0), List.of(0, 1)), permutations.permute(new int[]{0, 1}));
        assertEquals(List.of(List.of(0)), permutations.permute(new int[]{0}));
        assertEquals(List.of(
                List.of(1, 2, 3),
                List.of(3, 2, 1),
                List.of(2, 1, 3),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 3, 1)
                ),
                permutations.permute(new int[]{1, 2, 3}));
        assertEquals(List.of(
                List.of(1, 1, 2),
                List.of(2, 1, 1),
                List.of(1, 2, 1)
                ),
                permutations.permute(new int[]{1, 1, 2}));
    }
}
