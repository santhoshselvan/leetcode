package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClosestKElementsTest {

    @Test
    void shouldFindClosestKElements() {
        var closestKElements = new ClosestKElements();

        assertEquals(List.of(1,2,3,4),
                closestKElements.findClosestElements(new int[] {1,2,3,4,5}, 4, 3));

        assertEquals(List.of(1,2,3,4),
                closestKElements.findClosestElements(new int[] {1,2,3,4,5}, 4, -1));

        assertEquals(List.of(2,3),
                closestKElements.findClosestElements(new int[] {1,2,3,4,5}, 2, 3));

        assertEquals(List.of(8, 8),
                closestKElements.findClosestElements(new int[] {6, 7, 8, 8, 9, 10, 11, 12, 13}, 2, 8));

        assertEquals(List.of(6, 7, 8, 8, 9),
                closestKElements.findClosestElements(new int[] {6, 7, 8, 8, 9, 10, 11, 12, 13}, 5, 8));

        assertEquals(List.of(9, 10, 11, 12, 13),
                closestKElements.findClosestElements(new int[] {6, 7, 8, 8, 9, 10, 11, 12, 13}, 5, 444));

        assertEquals(List.of(6, 7, 8, 8, 9),
                closestKElements.findClosestElements(new int[] {6, 7, 8, 8, 9, 10, 11, 12, 13}, 5, -444));
    }
}
