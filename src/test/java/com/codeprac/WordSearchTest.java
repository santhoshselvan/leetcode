package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void shouldFindThePresenceOfWordInBoard() {
        var wordSearch = new WordSearch();
//        assertTrue(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
//                "ABCCED"));
//
//
//        assertTrue(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
//                "SEE"));

        assertFalse(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
                "ABCB"));
    }

    @Test
    void shouldFindNeighbour() {
//        00 01 02 03
//        10 11 12 13
//        20 21 22 23
//        30 31 32 33
        assertEquals(List.of(
                WordSearch.Index.of(1, 1),
                WordSearch.Index.of(1, 2),
                WordSearch.Index.of(1, 3),
                WordSearch.Index.of(2, 1),
                WordSearch.Index.of(2, 3),
                WordSearch.Index.of(3, 1),
                WordSearch.Index.of(3, 2),
                WordSearch.Index.of(3, 3)
        ), WordSearch.getNeighbours(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'},
                        {'A', 'D', 'E', 'E'}},
                new WordSearch.Index(2, 2)));

        assertEquals(List.of(
                WordSearch.Index.of(1, 1),
                WordSearch.Index.of(1, 2),
                WordSearch.Index.of(1, 3),
                WordSearch.Index.of(2, 1),
                WordSearch.Index.of(2, 3)
        ), WordSearch.getNeighbours(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                new WordSearch.Index(2, 2)));

        assertEquals(List.of(
                WordSearch.Index.of(0, 1),
                WordSearch.Index.of(1, 0),
                WordSearch.Index.of(1, 1)
        ), WordSearch.getNeighbours(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                new WordSearch.Index(0, 0)));

        assertEquals(List.of(
                WordSearch.Index.of(1, 2),
                WordSearch.Index.of(1, 3),
                WordSearch.Index.of(2, 2)
        ), WordSearch.getNeighbours(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}},
                new WordSearch.Index(2, 3)));



    }
}
