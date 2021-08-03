package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegExMatcherTest {

    @Test
    void shouldTestMatching() {
        var regExMatcher = new RegExMatcher();


        assertFalse(regExMatcher.isMatch("aa", "a"));
        assertTrue(regExMatcher.isMatch("hello", "hello"));
        assertFalse(regExMatcher.isMatch("helloooo", "hello"));
        assertTrue(regExMatcher.isMatch("hello", "he.lo"));
        assertTrue(regExMatcher.isMatch("aaaaaa", "a*"));
        assertTrue(regExMatcher.isMatch("aa", "a*"));
        assertTrue(regExMatcher.isMatch("aaaaaabcd", "a*bcd"));
        assertTrue(regExMatcher.isMatch("bcd", "a*bcd"));
        assertTrue(regExMatcher.isMatch("aab", "a*b"));
        assertTrue(regExMatcher.isMatch("aabbbbbbbbbb", "a*b*"));
        assertTrue(regExMatcher.isMatch("aabbbbbbbbbbc", "a*b*c"));
        assertTrue(regExMatcher.isMatch("aab", "c*a*b"));
        assertTrue(regExMatcher.isMatch("aab", ".*"));
        assertTrue(regExMatcher.isMatch("aab", "a*.*"));
        assertFalse(regExMatcher.isMatch("mississippi", "mis*is*p*."));
        assertTrue(regExMatcher.isMatch("aaa", "a*a"));
        assertTrue(regExMatcher.isMatch("aaa", "a*aaaaa"));
        assertTrue(regExMatcher.isMatch("aaa", "ab*a*c*a"));
        assertTrue(regExMatcher.isMatch("a", "ab*"));
    }

}
