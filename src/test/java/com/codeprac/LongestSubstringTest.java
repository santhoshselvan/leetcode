package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    public void shouldFindLongestSubstringWithoutRepeatingCharacters() {
        assertEquals(3, new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new LongestSubstring().lengthOfLongestSubstring("bbbbb"));
        assertEquals(   3, new LongestSubstring().lengthOfLongestSubstring("pwwkew"));
        assertEquals(   6, new LongestSubstring().lengthOfLongestSubstring("santhosh"));
        assertEquals(   8, new LongestSubstring().lengthOfLongestSubstring("As I am suffering from fever"));
        assertEquals(   0, new LongestSubstring().lengthOfLongestSubstring(""));
        assertEquals(   1, new LongestSubstring().lengthOfLongestSubstring(" "));
        assertEquals(   3, new LongestSubstring().lengthOfLongestSubstring("dvdf"));
        assertEquals(   4, new LongestSubstring().lengthOfLongestSubstring("abcd".repeat(50000/4)));
        assertEquals(   1, new LongestSubstring().lengthOfLongestSubstring(" ".repeat(50000)));

        assertEquals(   7, new LongestSubstring().lengthOfLongestSubstring("eosutaohunteoh"));
        assertEquals(   2, new LongestSubstring().lengthOfLongestSubstring("jm"));
        assertEquals(   1, new LongestSubstring().lengthOfLongestSubstring("**"));
        assertEquals(   13, new LongestSubstring().lengthOfLongestSubstring("atoehuteouhneu'qnt jdeorgfueothueoiufaoientdhouioe"));
    }
}
