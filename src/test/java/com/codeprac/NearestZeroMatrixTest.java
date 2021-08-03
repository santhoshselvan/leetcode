package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestZeroMatrixTest {

    @Test
    void shouldFindNearestZero() {
        var nearestZeroMatrix = new NearestZeroMatrix();
        assertArrayEquals(
                new int[][]{{0,0,0},{0,1,0},{0,0,0}},
                nearestZeroMatrix.updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}})
        );

        assertArrayEquals(
                new int[][]{{0,0,0},{0,1,0},{1,2,1}},
                nearestZeroMatrix.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}})
        );

        assertArrayEquals(
                new int[][]{{0}, {0}, {0}, {0},},
                nearestZeroMatrix.updateMatrix(new int[][]{{0}, {0}, {0}, {0},})
        );
    }
}
