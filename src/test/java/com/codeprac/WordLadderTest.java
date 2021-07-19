package com.codeprac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeprac.WordLadder.DiffCount.MORE_THAN_ONE;
import static com.codeprac.WordLadder.DiffCount.ONE;
import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {
    WordLadder wordLadder = new WordLadder();

    @Test
    void shouldFindLadder() {

//        assertEquals(
//                List.of("dog", "cog"),
//                wordLadder.findLadder("dog", "cog", List.of("hot","dot","dog","lot","log","cog")));
//
//        assertEquals(
//                List.of("dot", "dog", "cog"),
//                wordLadder.findLadder("dot", "cog", List.of("dog","lot","log","cog")));

        assertEquals(
                List.of("hit", "hot", "dot", "dog", "cog"),
                wordLadder.findLadder("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }

    @Test
    void shouldReturnZeroIfLadderNotPossible() {
        assertEquals(
                List.of(),
                wordLadder.findLadder("fat", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }

    @Test
    void shouldFindNumberOfDifferentLettersBetweenTwoWords() {
        assertEquals(ONE, wordLadder.findDiff("hit", "hot"));
        assertEquals(MORE_THAN_ONE, wordLadder.findDiff("hit", "hog"));
    }
}
