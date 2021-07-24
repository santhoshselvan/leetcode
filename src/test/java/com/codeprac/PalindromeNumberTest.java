package com.codeprac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void shouldTestPalindrome() {
        var palindromeNumber = new PalindromeNumber();

        assertFalse(palindromeNumber.isPalindrome(-12));
        assertTrue(palindromeNumber.isPalindrome(01));
        assertTrue(palindromeNumber.isPalindrome(1));
        assertTrue(palindromeNumber.isPalindrome(0));
        assertTrue(palindromeNumber.isPalindrome(00000000));
        assertFalse(palindromeNumber.isPalindrome(123));
        assertFalse(palindromeNumber.isPalindrome(1287847903));
        assertTrue(palindromeNumber.isPalindrome(121));
        assertTrue(palindromeNumber.isPalindrome(969999969));
    }
}
