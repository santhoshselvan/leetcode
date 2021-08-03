package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternCursorTest {

    @Test
    void shouldGetCursor() {
        var patternCursor = new PatternCursor("xa*a.b+c");

        assertEquals("x", patternCursor.next());
        assertEquals("a*", patternCursor.next());
        assertEquals("a", patternCursor.next());
        assertEquals(".", patternCursor.next());
        assertEquals("b+", patternCursor.next());
        assertEquals("c", patternCursor.next());
        assertNull(patternCursor.next());
    }
}
