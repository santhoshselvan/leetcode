package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    @Test
    void shouldFindValidParenthesis() {
        var validParenthesis = new ValidParenthesis();

        assertTrue(validParenthesis.isValid("()"));
        assertTrue(validParenthesis.isValid("()[]{}"));
        assertTrue(validParenthesis.isValid("((()))"));
        assertTrue(validParenthesis.isValid("((({}[])))"));
        assertTrue(validParenthesis.isValid("((({}[()])))"));

        assertFalse(validParenthesis.isValid("((({}[)])))"));
        assertFalse(validParenthesis.isValid("()[]{]"));
        assertFalse(validParenthesis.isValid("(]"));
        assertFalse(validParenthesis.isValid("(((()))"));
    }
}
