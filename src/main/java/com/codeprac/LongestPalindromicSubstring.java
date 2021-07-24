package com.codeprac;

import java.util.HashSet;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String input) {
        HashSet<String> palindromes = new HashSet<>();

        if (isPalindrome(input)) return input;

        var longestPalindrome = "";
        var longestPalindromeLength = 0;
        int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
            var radius = 0;
            while (radius <= i && radius < (inputLength - i)) {

                int beginIndex = i - radius;
                int endIndex = i + radius;
                radius++;
                if (input.charAt(beginIndex) != input.charAt(endIndex)) continue;
                if ((endIndex - beginIndex) < longestPalindromeLength) continue;
                var substring = input.substring(beginIndex, endIndex + 1);
                if (isPalindrome(substring)) {
                    longestPalindrome = substring;
                    longestPalindromeLength = endIndex - beginIndex + 1;
                } else break;
            }
        }

        for (int i = 1; i < inputLength; i++) {
            var radius = 0;
            while (radius < i && radius < (inputLength - i)) {

                int beginIndex = i - 1 - radius;
                int endIndex = i + radius;
                radius++;
                if (input.charAt(beginIndex) != input.charAt(endIndex)) continue;
                if ((endIndex - beginIndex) < longestPalindromeLength) continue;
                var substring = input.substring(beginIndex, endIndex + 1);
                if (isPalindrome(substring)) {
                    longestPalindrome = substring;
                    longestPalindromeLength = endIndex - beginIndex + 1;
                } else break;
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String input) {
        var sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return input.equals(sb.toString());
    }
}
