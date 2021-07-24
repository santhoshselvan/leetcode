package com.codeprac;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        var reversed = 0;
        var itr = x;
        while (itr != 0) {
            reversed = (reversed * 10) + itr % 10;
            itr = itr / 10;
        }

        return x == reversed;
    }
}
