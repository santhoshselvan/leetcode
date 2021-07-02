package com.codeprac;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int lengthOfSubstring = 0;
        int substringStartingIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            var currentSubstring = s.substring(substringStartingIndex, i);

            if (currentSubstring.contains(String.valueOf(currentChar))) {
                maxLength = Math.max(maxLength, lengthOfSubstring);
                int previousOccurrenceIndex = substringStartingIndex + currentSubstring.indexOf(currentChar);
                substringStartingIndex = previousOccurrenceIndex + 1;
                lengthOfSubstring = i - substringStartingIndex + 1;
            } else {
                lengthOfSubstring++;
            }
        }
        return Math.max(maxLength, lengthOfSubstring);
    }
}
