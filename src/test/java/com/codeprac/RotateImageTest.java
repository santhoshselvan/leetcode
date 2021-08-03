package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {

    @Test
    void shouldRotateImage() {
        var rotateImage = new RotateImage();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateImage.rotate(matrix);

        assertArrayEquals(
                new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}},
                matrix
        );
    }
}
